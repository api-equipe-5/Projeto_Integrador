<?php

namespace App\Http\Controllers;
use Illuminate\Http\Request;
use App\Models\User;
use App\Models\Mensagens;

class indexController extends Controller
{
    /**
     * Create a new controller instance.
     *
     * @return void
     */
    public function __construct()
    {
        $this->middleware('auth');
    }

    /**
     * Show the application dashboard.
     *
     * @return \Illuminate\Contracts\Support\Renderable
     */
    public function index()
    {   
        $msgs = Mensagens::orderBy('created_at', 'desc')->get();
        return view('admin.index', compact('msgs'));

    }

    public function home()
    {
       
        return view('welcome');
    }

}
