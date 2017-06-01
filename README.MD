
#### 1. 设计的实体类
| 表实体类      |     表注释 |   对应关系   |
| :-------- | :--------| :------ |
| User |   用户 |  与UserGroup为多对多关系，被拥有方|
| UserGroup|   用户组|  与User为多对多关系，拥有方；与PermissionGroup为多对多关系，拥有方|
| Permission|   权限|  与PermissionGroup为多对多关系，被拥有方；与UserGroup为多对多关系，被拥有方|
| PermissionGroup|   权限组|  与Permission为多对多关系，拥有方；|

#### 2. 根据主键获取用户、用户组、权限或权限组等对象
> GET /v1/base/findObjectByPk
###### a) 用户: 用户信息、所属用户组、所属权限组、拥有权限
###### b) 用户组: 用户组信息、所属权限组、权限
###### c) 权限组: 权限组信息、权限
###### d) 权限: 权限信息