<?php
//Clear Cache facade value:
Route::get('/clear-cache', function () {
    $exitCode = Artisan::call('cache:clear');
    return '<h1>Cache facade value cleared</h1>';
});

//Reoptimized class loader:
Route::get('/optimize', function () {
    $exitCode = Artisan::call('optimize');
    return '<h1>Reoptimized class loader</h1>';
});

//Route cache:
Route::get('/route-cache', function () {
    $exitCode = Artisan::call('route:cache');
    return '<h1>Routes cached</h1>';
});

//Clear Route cache:
Route::get('/route-clear', function () {
    $exitCode = Artisan::call('route:clear');
    return '<h1>Route cache cleared</h1>';
});

//Clear View cache:
Route::get('/view-clear', function () {
    $exitCode = Artisan::call('view:clear');
    return '<h1>View cache cleared</h1>';
});

//Clear Config cache:
Route::get('/config-cache', function () {
    $exitCode = Artisan::call('config:cache');
    return '<h1>Clear Config cleared</h1>';
});



Auth::routes();

Route::group(['prefix'=>'/admin','middleware'=>['auth'], 'as'=>'admin.'], function () {
    Route::get('/', ['as'=>'home','uses'=>'indexController@index']);
    Route::get('/ver_mensagem/{id}', ['as'=>'ver_mensagem','uses'=>'Painel\MensagensController@ver_mensagem']);
    Route::get('/delete_msg/{id}', ['as'=>'delete_msg','uses'=>'Painel\MensagensController@delete_msg']);

    Route::group(['prefix'=>'voluntarios','as'=>'voluntarios.'], function () {
        Route::get('/lista', ['as'=>'lista','uses'=>'Painel\VoluntariosController@lista']);
        Route::get('/novo', ['as'=>'novo','uses'=>'Painel\VoluntariosController@novo']);
        Route::get('/editar/{id}', ['as'=>'editar','uses'=>'Painel\VoluntariosController@editar']);
        Route::post('store', ['as'=>'store','uses'=>'Painel\VoluntariosController@store']);
        Route::post('/update/{id}', ['as'=>'update','uses'=>'Painel\VoluntariosController@update']);
        Route::get('/delete/{id}', ['as'=>'delete','uses'=>'Painel\VoluntariosController@delete']);
    });

    Route::group(['prefix'=>'participantes','as'=>'participantes.'], function () {
        Route::get('/lista', ['as'=>'lista','uses'=>'Painel\ParticipantesController@lista']);
        Route::get('/novo', ['as'=>'novo','uses'=>'Painel\ParticipantesController@novo']);
        Route::get('/editar/{id}', ['as'=>'editar','uses'=>'Painel\ParticipantesController@editar']);
        Route::post('store', ['as'=>'store','uses'=>'Painel\ParticipantesController@store']);
        Route::post('/update/{id}', ['as'=>'update','uses'=>'Painel\ParticipantesController@update']);
        Route::get('/delete/{id}', ['as'=>'delete','uses'=>'Painel\ParticipantesController@delete']);
    });

    Route::group(['prefix'=>'projetos','as'=>'projetos.'], function () {
        Route::get('/lista', ['as'=>'lista','uses'=>'Painel\ProjetosController@lista']);
        Route::get('/novo', ['as'=>'novo','uses'=>'Painel\ProjetosController@novo']);
        Route::get('/editar/{id}', ['as'=>'editar','uses'=>'Painel\ProjetosController@editar']);
        Route::post('store', ['as'=>'store','uses'=>'Painel\ProjetosController@store']);
        Route::get('/download/{id}', ['as'=>'download','uses'=>'Painel\ProjetosController@download']);
        Route::get('/share/{id}', ['as'=>'share','uses'=>'Painel\ProjetosController@share']);
        Route::post('/update/{id}', ['as'=>'update','uses'=>'Painel\ProjetosController@update']);
        Route::get('/delete/{id}', ['as'=>'delete','uses'=>'Painel\ProjetosController@delete']);
    });

    Route::group(['prefix'=>'users','as'=>'users.'], function () {
        Route::get('/lista', ['as'=>'lista','uses'=>'Painel\UserController@lista']);
        Route::get('/novo', ['as'=>'novo','uses'=>'Painel\UserController@novo']);
        Route::get('/create', ['as'=>'create','uses'=>'Painel\UserController@create']);
        Route::get('/editar/{id}', ['as'=>'editar','uses'=>'Painel\UserController@editar']);
        Route::get('/delete/{id}', ['as'=>'delete','uses'=>'Painel\UserController@delete']);
        Route::post('/update/{id}', ['as'=>'update','uses'=>'Painel\UserController@update']);
    }); 

    Route::group(['prefix'=>'futuros','as'=>'futuros.'], function () {
        Route::get('/lista', ['as'=>'lista','uses'=>'Painel\VoluntariosController@listaNovos']);
        Route::get('/view/{id}', ['as'=>'view','uses'=>'Painel\VoluntariosController@view']);
        Route::get('/delete/{id}', ['as'=>'delete','uses'=>'Painel\VoluntariosController@deleteView']);
    }); 

    Route::group(['prefix'=>'ajax','as'=>'ajax.'], function () {
        Route::POST('/uploadimg', 'Painel\MediaController@upload_img')->name('uploadimg');
    }); 

    Route::middleware(['SuperAdmin'])->group(function(){
        Route::group(['prefix'=>'inaprovados','as'=>'inaprovados.'], function () {
            Route::get('/lista', ['as'=>'lista','uses'=>'Painel\ProjetosController@listaInaprovados']);
            Route::get('/avaliar-projeto/{id}', ['as'=>'avaliar','uses'=>'Painel\ProjetosController@avaliar']);
            Route::post('/update/{id}', ['as'=>'update','uses'=>'Painel\ProjetosController@updateInaprovado']);

        });
    });
    Route::get('/404', function () {
        return view('errors.404-painel');
    })->name('404-painel');

    Route::get('logout', ['as'=>'logout','uses'=>'Auth\LoginController@logout']);

});

Route::get('/', ['as'=>'home','uses'=>'Site\PaginasController@Home']);

Route::get('/voluntarios', ['as'=>'voluntarios','uses'=>'Site\PaginasController@voluntarios']);
Route::get('/projetos', ['as'=>'projetos','uses'=>'Site\PaginasController@projetos']);
Route::get('/contato', ['as'=>'contato','uses'=>'Site\PaginasController@contato']);
Route::post('/enviar-contato', ['as'=>'enviar-contato','uses'=>'Site\PaginasController@enviar_contato']);
Route::get('/cadastro', ['as'=>'cadastro','uses'=>'Site\PaginasController@cadastro']);
Route::post('/enviar-cadastro', ['as'=>'enviar-cadastro','uses'=>'Site\PaginasController@enviar_cadastro']);

Route::get('/lista', ['as'=>'lista','uses'=>'Site\ProjetosController@lista']);
Route::group(['prefix'=>'projetos','as'=>'projetos.'], function () {
    Route::get('/{slug}', ['as'=>'projeto','uses'=>'Site\PaginasController@projeto']);
}); 

