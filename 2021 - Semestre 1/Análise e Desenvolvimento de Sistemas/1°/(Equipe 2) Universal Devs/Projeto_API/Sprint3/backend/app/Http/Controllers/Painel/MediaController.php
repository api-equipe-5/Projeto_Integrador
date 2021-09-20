<?php

namespace App\Http\Controllers\Painel;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Illuminate\Support\Str;
use App\Models\Media;

class MediaController extends Controller
{
    public function upload_img(Request $request)
    {
        $arrayFile = array();
        $files = Request(['imagePath']);
        foreach ($files as $file) {
            $e = explode(".", $file->getClientOriginalName());
            $n = str_replace(end($e), "", $file->getClientOriginalName());
            $newName = Str::slug($n, "-") .".".end($e);
            $fileName = time(). "-". $newName;
            $arrayFile[] = $fileName;
            $file->move('uploads/img/', $fileName);

            Media::create([
                'file'=>$fileName,
                'type'=>end($e),
                'path'=>'uploads/img/']);
        }
        return response()->json($arrayFile);
    }
}
