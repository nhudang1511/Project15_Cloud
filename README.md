# Project15_Cloud
Đề tài 15: Tìm hiểu về database Amazon Aurora

Danh sách nhóm

Nguyễn Thị Quỳnh Như - 20110235

Lâm Hoàng Duyên - 20110174

Nguyễn Mai Tiên - 20110255
Các bước chạy đồ án
1. Tạo cơ sở dữ liệu Amazon Aurora
-	Trên Services menu, chọn dịch vụ RDS.
- Chọn Create database
-	Trên Services menu, chọn dịch vụ RDS.
-	Ở Choose a database creation method section, chọn Standard create: để được tự lựa chọn các tính năng phù hợp
-	Trong Engine options: Engine type: chọn dịch vụ Amazon Aurora.
-	 For Templates, choose Dev/Test.
-	Sau khi đổi tên ở mục DB cluster identifier, cài đặt password
-	Ở mục Instance configuration: chọn Burstable classes (includes t classes) -> Chọn db.t3.medium
-	Ở mục Public access, chọn Yes để Amazon EC2 instances và các nguồn khác của VPC có thể truy cập đến cluster.
-	Mở rộng mục Additional Configuration, gỡ chọn “Enable Enhanced monitoring”, đồng thời đổi lại tên của Initial Database
-	Nhập 1 vào ô trống trong mục “Target Backtrack window”
-	Tại Backtrack, nhấn chọn Enable Backtrack
-	Choose Create database.
-	New database displays in the list of databases. The status is Creating.
2. Kết nối cơ sở dữ liệu vừa tạo với MySQL trên máy tính 
- Kiểm tra và kết nối MySQL trên máy tính với database Aurora vừa tạo
-	Thêm dữ liệu vào database 
-	Kết nối dữ liệu với web và chạy demo local
•	Sửa trong file persistence.xml 
•	Thêm dữ liệu thành công
3. Cài đặt EC2 instances để host web
-	Tạo EC2
•	Trên Services menu  EC2.
•	Chọn the Launch instance 
•	Đặt tên cho Instance
•	Chọn Amazon Linux
•	Ở mục Key pair (login), chọn Create new key pair, đặt tên cho Key pair
•	Chọn Edit ở mục Network settings, thay đổi Source type thành “My IP”
•	Thêm các rule như sau:
•	Choose Launch instance và hiện thị thông báo Success message.
•	Sau khi Database đã tạo thành công, điều chỉnh lại một số thông tin Type: MySQL/Aurora: Tick vào cơ sở dữ liệu được tạo, chọn Security -> Inbound rules -> edit inbound rules
•	Chọn Save rules.
-	Cài đặt Putty để kết nối EC2
•	Thêm key pair được tạo phía trên vào PuttyGen để tạo private key
•	Copy địa chỉ “Public Ipv4 DNS’ rồi mở Putty lên, dán địa chỉ vừa copy vào Host Name 
•	Tiến hành cài đặt Java và cấu hình môi trường
-	Cài đặt Java cho EC2 instances: sử dụng các lệnh sau
•	sudo yum update -y
•	sudo yum list | grep openjdk: hiện thị danh sách các file Java
•	sudo yum install java-1.8.0-openjdk.x86_64: cài đặt java phiên bản 1.8.0
•	java –version: kiểm tra phiên bản
•	cd ~
•	ls -la
•	file $(which java)
•	file /etc/alternatives/java
•	sudo nano .bash_profile
JAVA_HOME="/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.222.b10-0.amzn2.0.1.x86_64/jre"
PATH=$JAVA_HOME/bin:$PATH
•	source .bash_profile
-	Cài đặt Tomcat cho EC2 instances
•	Download:
  wget https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.84/bin/apache-tomcat-8.5.84.tar.gz
  tar xvzf apache-tomcat-8.5.84.tar.gz
  rm - r apache-tomcat-8.5.84.tar.gz
•	Cài đặt:
  cd apache-tomcat-8.5.84/
  cd bin
  ./startup.sh
  ps -ef | grep tomcat
  wget http://localhost:8080
•	Cấp quyền truy cập vào manager gui
  cd conf
  vi tomcat-users.xml
  Thêm vào tomcat-users.xml để tạo 1 user: 
      <role rolename="manager-gui"/>
      <user username="admin" password="password" roles="manager-gui,manager-status,manager-script,manager-jmx,admin-gui"/>
  cd webapps\manager\META-INF\
  vi context.xlm
-	Cài đặt MySQL cho EC2 instaces 
•	sudo yum localinstall https://dev.mysql.com/get/mysql80-community-release-el7-7.noarch.rpm
•	sudo yum install mysql-community-server
•	sudo systemctl start mysqld/sudo service mysqld start
•	sudo systemctl enable mysqld
•	mysql -u admin -h -p
•	show databases;
-	Đưa file web.war lên ec2 và chạy trên web trên mạng http:
4. Demo một số tính năng của Aurora 
