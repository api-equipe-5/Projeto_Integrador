
exports.up = function(knex) {
	return knex.schema.createTable('employee', function (table) {
	  table.increments();
	  table.string('name');
	  table.string('email');
	  table.string('password');
	})
};

exports.down = function(knex) {
 	return knex.schema.dropTable('employee')
};
