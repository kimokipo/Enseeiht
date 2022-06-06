import http from 'http'
import fs from 'fs'
var server = http.createServer();
server.on('request',(request,response) => {
        fs.readFile('./page_internte.html',null,(error,data) =>{
            if(error) {
                    response.write(404)
            }else{
                response.write(data)
            }
            response.end()
    })
})
server.listen(5000)
