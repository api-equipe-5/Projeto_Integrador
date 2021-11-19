<?php

namespace App\Providers;
use Illuminate\Support\Facades\View;
use Illuminate\Support\ServiceProvider;
use App\Models\Projeto;

class AppServiceProvider extends ServiceProvider
{

 
    /**
     * Register any application services.
     *
     * @return void
     */
    public function register()
    {       
        //
    }

    /**
     * Bootstrap any application services.
     *
     * @return void
     */
    public function boot()
    {
        $countProjetos = Projeto::where('status','inativo')->count();
        View::share('countProjetos', $countProjetos);
    }
}
