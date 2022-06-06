import mysql from 'mysql'
 
export default function dbconnect(){
        
        var connection = mysql.createConnection({
                host : '82.165.100.213',
                user : 'lalatomka',
                password : ',db5;z9*5H',
                database : 'group_fb_llc_v1'});
        connection.connect();
        return connection
}
