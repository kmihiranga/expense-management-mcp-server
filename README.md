# Expense management system

* MongoDB aggregation function to retrieve all user details along with profile and address details.

```bash
[
  {
    $match: {
      deleted: false
    }
  },
  {
    $lookup: {
      from: "ex_profiles",
      localField: "userId",
      foreignField: "ObjectId('id')",
      as: "profile"
    }
  },
  {
    $lookup: {
      from: "ex_addresses",
      localField: "userId",
      foreignField: "ObjectId('_id')",
      as: "address"
    }
  },
  {
    $unwind: {
      path: "$profile",
      preserveNullAndEmptyArrays: false
    }
  },
  {
    $unwind: {
      path: "$address",
      preserveNullAndEmptyArrays: false
    }
  },
  {
    $unset: ['username', 
             'updatedDate', 
             '_class', 
             'deleted', 
             'profile.createdDate', 
             'profile.updatedDate', 
             'profile.deleted', 
             'profile.userId', 
             'profile._id', 
             'profile._class',
             'address._id',
             'address.createdDate',
             'address.updatedDate',
             'address.deleted',
             'address._class', 'address.userId']
  },
  {
    $project: {
      _id: 1,
      fullName: {$concat: ["$profile.firstName", " ", "$profile.lastName"]},
      phoneNumber: 1,
      age: "$profile.age",
      gender: "$profile.gender",
      email: 1,
      addressLine1: "$address.addressLine1",
      addressLine2: "$address.addressLine2",
      country: "$address.country",
      zipCode: "$address.zipCode",
      state: "$address.state",
      city: "$address.city",
      createdDate: 1
    }
  },
  {
    $sort: {
      createdDate: -1
    }
  }
]
```