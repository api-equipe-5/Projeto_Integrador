
exports.up = function(knex) {
	return knex.schema.createTable('users', function (table) {
	  table.increments();
	  table.string('name');
	  table.string('password');
	  table.string('email');
	  table.string('number');
	})
};

exports.down = function(knex) {
 	return knex.schema.dropTable('users')
};
