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

* for adding configurations to the claude code you should build the final project

* To build the final project you can run this gradle(here i'm using gradle for development) command

```bash
gradle build
```

* after building the final project, you should map your build jar file to the claude code configuration.

* To find the configurations, you can follow the path below.

```aiignore
Open Claude Code -> Settings -> Developer -> Edit Config
```

* After opening the `claude_desktop_config.json` file you should include below configuration and you should map the build jar file.

```bash
{
  "mcpServers": {
    "expensive_management_mcp_server": {
      "command": "java",
      "args": [
        "-jar",
        "/path/to/jar/file/expensive-management-mcp-server-0.0.1-SNAPSHOT.jar"
      ]
    }
  }
}
```
* The `expensive_management_mcp_server` name should be same as the `application.properties` file `spring.ai.mcp.server.name` property value.

* After adding the configurations you should restart the claude code application.