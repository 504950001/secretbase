
#### 1. 设计的实体类
| 表实体类      |     表注释 |   对应关系   |
| :-------- | :--------| :------ |
| User |   用户 |  与UserGroup为多对多关系，被拥有方|
| UserGroup|   用户组|  与User为多对多关系，拥有方；与PermissionGroup为多对多关系，拥有方|
| Permission|   权限|  与PermissionGroup为多对多关系，被拥有方；与UserGroup为多对多关系，被拥有方|
| PermissionGroup|   权限组|  与Permission为多对多关系，拥有方；|