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
    $sort: {
      createdDate: -1
    }
  }
]
```