/*
|--------------------------------------------------------------------------
| Routes
|--------------------------------------------------------------------------
|
| Http routes are entry points to your web application. You can create
| routes for different URL's and bind Controller actions to them.
|
| A complete guide on routing is available here.
| http://adonisjs.com/docs/4.1/routing
|
*/

/** @type {typeof import('@adonisjs/framework/src/Route/Manager')} */
const Route = use('Route');

Route.on('/').render('welcome');

Route.group(() => {
  Route.get('/', () => ({ name: 'Detector de talhões' }));
  Route.get('/download', 'DownloadRasters.index');
  Route.post('/prepare-train', 'GetScenesController.index');

  Route.get('/catalog/', 'CatalogController.search');
  Route.post('/catalog/geojson', 'CatalogController.searchGeoJSON');
  Route.get(
    '/catalog/:catalog_id/:scene_id/:band',
    'CatalogController.getBand'
  );
}).prefix('api/v1');
