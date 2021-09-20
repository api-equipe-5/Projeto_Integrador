<?php

namespace App\Providers;
use Illuminate\Support\Facades\View;
use Illuminate\Support\ServiceProvider;
use App\Models\Welcome_text;
use App\Models\Noticias;
use App\Models\Banners;
use App\Models\Frases;
use App\Models\Reflexao;

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
        
    }
}
