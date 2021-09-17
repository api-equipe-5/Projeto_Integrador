const fs = require('fs');

async function index(req, res) {
    const hash_comunicado = req.params.hash_comunicado;
    

    fs.readFile('./logs/'+hash_comunicado+'.log', 'utf8', function(err,data){
        if(err) {
            console.error("Could not open file: %s", err);
            process.exit(1);
        }
        
        res.json({data:data});
    });
}

module.exports = {
    index
}

