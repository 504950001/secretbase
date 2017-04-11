#### 笔记

#### 1. mappedBy 属性
表示关系由对方维护，自己将不再维护，就算在自己这端设置值，保存到数据库后外键依然是 null
网上搜点：
###### a） 只有OneToOne,OneToMany,ManyToMany上才有mappedBy属性，ManyToOne不存在该属性；
###### b） mappedBy标签一定是定义在the owned side（被拥有方的），他指向theowning side（拥有方）；
###### c） 关系的拥有方负责关系的维护，在拥有方建立外键。所以用到@JoinColumn
###### d）mappedBy跟JoinColumn/JoinTable总是处于互斥的一方
###### [参考资料链接地址](http://blog.csdn.net/denker2012/article/details/9071097)

#### 2. 理解JPA注解@GeneratedValue
###### a） AUTO：主键由程序控制。
###### b） SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
###### c） IDENTITY：主键由数据库自动生成（主要是自动增长型）
###### d） TABLE：使用一个特定的数据库表格来保存主键。
###### 注：如果使用@Id注解下不使用注解@GeneratedValue则必须手动设置id的值

#### 3. @ManyToMany中级联删除属性cascade
###### a） CascadeType.PERSIST:级联保存不要，学生没来之前，老师就已经在了。 
###### b）CascadeType.MERGE：级联更新不要，把学生的信息改了，没必要修改相应的老师的信息，压根就没这业务需求。 
###### c）CascadeType.REMOVE：级联删除更不要，如果双方都设了级联删除，加入删除学生，会删除相应的老师，被删除的老师又跟学生发生千丝万缕的关系，又把一批学生删掉.....没完没了...最终的结果可能是数据里面所有的记录都被清掉。 
###### 注：所以在多对多关系中，级联删除通常是用不上的 这里只需设置级联涮新CascadeType.PERSIST就可以了，事实上refresh方法也很少使用。 

#### 4. @JsonIgnore注解解决获取的@ManyToMany注解对象无限死循环的问题
###### - 在实体类@ManyToMany注解上方加@JsonIgnore注解，使获取对象时不用进入死循环而导致系统崩溃
