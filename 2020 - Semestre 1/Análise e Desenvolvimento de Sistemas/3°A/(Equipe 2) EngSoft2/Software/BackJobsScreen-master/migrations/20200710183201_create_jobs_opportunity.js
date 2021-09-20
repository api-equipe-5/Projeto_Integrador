
exports.up = function(knex) {
	return knex.schema.createTable('jobs', function (table) {
		table.increments();
		table.string('city')
		table.string('position')
		table.string('segment')
		table.boolean('active')
	})  
};

exports.down = function(knex) {
 	return knex.schema.dropTable('jobs') 
};
