import child_process from 'child_process'

(async function () { 
            const nomTable = process.argv[2]
            const nomParametre = process.argv[3] 
            const spawn = child_process.spawn
            const get_table = spawn('node', ['getDataTable.js', nomTable, nomParametre]);
            get_table.stdout.on('data', (data) => {
                  console.log(`${data}`);
                  get_table.kill('SiGINT');
                });

            
            
})();
