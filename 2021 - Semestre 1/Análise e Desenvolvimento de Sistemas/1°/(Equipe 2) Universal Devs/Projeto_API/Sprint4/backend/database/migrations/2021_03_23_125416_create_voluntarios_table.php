<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateVoluntariosTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('voluntarios', function (Blueprint $table) {
            $table->id();
            $table->string('name')->nullable();
            $table->string('rg', 20)->nullable();
            $table->string('cpf', 25)->nullable();
            $table->string('endereco',500)->nullable();
            $table->string('cidade')->nullable();
            $table->string('estado')->nullable();
            $table->string('nacionalidade')->nullable();
            $table->string('profissao')->nullable();
            $table->enum('tipo',['geral','especifico','removido','inativo']);
            $table->string('telefone')->nullable();
            $table->string('email')->nullable();
            $table->string('horario')->nullable();
            $table->enum('dias_disponiveis',['domingo','segunda','terca','quarta','quinta','sexta','sabado'])->nullable();
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('voluntarios');
    }
}
