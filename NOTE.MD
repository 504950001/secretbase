#### 笔记

#### 1. mappedBy 属性
表示关系由对方维护，自己将不再维护，就算在自己这端设置值，保存到数据库后外键依然是 null
网上搜点：
###### a） 只有OneToOne,OneToMany,ManyToMany上才有mappedBy属性，ManyToOne不存在该属性；
###### b） mappedBy标签一定是定义在the owned side（被拥有方的），他指向theowning side（拥有方）；
###### c） 关系的拥有方负责关系的维护，在拥有方建立外键。所以用到@JoinColumn
###### d）mappedBy跟JoinColumn/JoinTable总是处于互斥的一方
###### [参考资料链接地址](http://blog.csdn.net/denker2012/article/details/9071097)

