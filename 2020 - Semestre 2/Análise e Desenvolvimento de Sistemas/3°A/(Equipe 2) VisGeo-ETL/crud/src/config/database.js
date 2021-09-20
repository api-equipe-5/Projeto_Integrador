module.exports = {
  dialect: 'postgres',
  host: 'localhost',
  username: 'postgis',
  password: 'root',
  database: 'gis',
  define: {
    timestamp: true,
    underscored: true,
    underscoredAll: true,
  },
};
