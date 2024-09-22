#==============================================================================================================================================#

# Install MySQL 8.0 
brew install mysql@8.0

# Start the MySQL server
brew services start mysql@8.0

# Secure
mysql_secure_installation

#==============================================================================================================================================#

# Edit path configuration:
nano ~/.zshrc

# Add the following:
export PATH="/opt/homebrew/opt/mysql@8.0/bin:$PATH"

#----------- START, STOP, RESTART, CHECK STATUS, AND CONNECT, FROM ANYWHERE -------------#|
                                                                                          #\ 
# start/stop/restart.                                                                     #|
mysql.server start                                                                        #|
mysql.server stop                                                                         #|
mysql.server restart                                                                      #|
                                                                                          #|
# Connect to server.                                                                      #|
mysql -u "yourUsername" -p                                                                #|
                                                                                          #|
# Check status.                                                                           #|
mysql.server status                                                                       #|
ps aux | grep mysqld                                                                      #|
                                                                                          #/     
#------------------- INSTEAD OF ---------------------------------------------------------#|
                                                                                          #\  
# start/stop/restart.                                                                     #|
/opt/homebrew/opt/mysql@8.0/bin/mysql.server start                                        #| 
/opt/homebrew/opt/mysql@8.0/bin/mysql.server stop                                         #| 
/opt/homebrew/opt/mysql@8.0/bin/mysql.server restart                                      #| 
                                                                                          #|
# Connect to server.                                                                      #| 
/opt/homebrew/opt/mysql@8.0/bin/mysql -u "yourUsername" -p                                #|
                                                                                          #| 
# Check status.                                                                           #| 
/opt/homebrew/opt/mysql@8.0/bin/mysql.server status                                       #| 
                                                                                          #/     
#----------------------------------------------------------------------------------------#| 

# Reload:
source ~/.zshrc

#==============================================================================================================================================#

# Check for errors:
cat /opt/homebrew/var/mysql/daniels-air.err
tail -n 50 /opt/homebrew/var/mysql/daniels-air.err

#==============================================================================================================================================#

# Safe mode - this runs MySQL in the background and allows you to log in without a password.
mysqld_safe --skip-grant-tables &

#Check if it runs.
ps aux | grep mysqld_safe

# Login to MySQL.
mysql -u root

# Reset the Password.
FLUSH PRIVILEGES;
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'new_password';

# Create User
CREATE USER 'yourUsername'@'localhost' IDENTIFIED BY 'your_password';

# Give the appropriate privileges:
GRANT ALL PRIVILEGES ON *.* TO 'yourUsername'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;                                                       
                                                                      
#==============================================================================================================================================#
                                                                        #\
# Edit configuration file.                                              #|
nano /opt/homebrew/etc/my.cnf                                           #|
                                                                        #/                                                                    
#----------------- Prefered MySQL configuration -----------------------#| 
                                                                        #\
[mysqld]                                                                #|
bind-address = 127.0.0.1                                                #|
socket = /tmp/mysql.sock                                                #|
user = yourUsername                                                     #|
port = 3306                                                             #|
                                                                        #/                                                 
#----------------- Optional MySQL configuration -----------------------#|
                                                                        #\
# Logging                                                               #|
log_error = /path/to/your/desired/location/mysql_error.log              #|
general_log_file = /path/to/your/desired/location/mysql_general.log     #|
general_log = 1                                                         #|
                                                                        #|
# Character set settings                                                #|
character-set-server = utf8mb4                                          #|
collation-server = utf8mb4_unicode_ci                                   #|
                                                                        #/
#==============================================================================================================================================#
                                                                         
# Test connection via Terminal                                         
mysql -u yourUsername -p -h localhost                                  
                                                                        
#======================================================#|
                                                        #\
# CHECK HOSTNAME:                                       #|
SHOW VARIABLES LIKE 'hostname';                         #| 
                                                        #|
      +---------------+-------------+                   #| 
      | Variable_name | Value       |                   #|                
      +---------------+-------------+                   #|             
      | hostname      | yourMac-pro |                   #|
      +---------------+-------------+                   #|
                                                        #/
#======================================================#| 
                                                        #\
# CHECK PORT:                                           #| 
SHOW VARIABLES LIKE 'port';                             #|  
                                                        #|
      +---------------+-------+                         #|
      | Variable_name | Value |                         #|
      +---------------+-------+                         #|
      | port          | 3306  |                         #|
      +---------------+-------+                         #|
                                                        #/
#======================================================#| 
                                                        #\
# CHECK USERS:                                          #|  
SELECT User, Host FROM mysql.user;                      #|
                                                        #|
      +------------------+-----------+                  #|
      | User             | Host      |                  #|
      +------------------+-----------+                  #|
      | yourUsername     | localhost |                  #|
      | mysql.infoschema | localhost |                  #|
      | mysql.session    | localhost |                  #|
      | mysql.sys        | localhost |                  #|
      | root             | localhost |                  #|
      +------------------+-----------+                  #|
                                                        #/
#==============================================================================================================================================#
