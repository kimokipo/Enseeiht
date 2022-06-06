import child_process from 'child_process'

(async function () { 
            const L = process.argv[2]
            const R = process.argv[3]
            const T = process.argv[4]
            const W = process.argv[5]
            const spawn = child_process.spawn
            const get_table = spawn('java', ['linda.test.ApplicationTestCacheMultiThread', L,R,T,W]);
            get_table.stdout.on('data', (data) => {
                  console.log(`${data}`);
                  //get_table.kill('SiGINT');
                });

            
            
})();
