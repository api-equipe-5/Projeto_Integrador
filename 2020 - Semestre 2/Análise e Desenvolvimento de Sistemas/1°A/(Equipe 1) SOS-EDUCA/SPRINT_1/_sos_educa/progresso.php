<?php

  return function ($location) {
    $locations = [
      "Carrinho",
      "Cadastro",
      "Pagamento",
      "Confirmação"
    ];

    if ($location > sizeof($locations)) {
      $locations = sizeof($locations);
    }
    
    ?>
      <style>
        @media print {
          .steps-form {
            display: none !important;
          }
        }
        
        .steps-form {
          display: table;
          width: 100%;
          max-width: 1024px;
          padding: 37px 0 20px;
          margin: 0 auto;
          position: relative;
        }
        .steps-form .steps-row {
          display: table-row;
        }
        .steps-form .steps-row:before {
          top: 50px;
          bottom: 0;
          position: absolute;
          content: " ";
          width: 100%;
          height: 3px;
          background-image: linear-gradient(90deg, rgb(0 0 0 / 0%) 0%, rgba(0, 0, 0, 0.2) 10% 90%, rgb(0 0 0 / 0%) 100%);
        }
        .steps-form .steps-row .steps-step {
          display: table-cell;
          text-align: center;
          position: relative;
        }
        .steps-form .steps-row .steps-step p {
          margin-top: 0.5rem;
        }
        .steps-form .steps-row .steps-step button[disabled] {
          opacity: 1 !important;
          filter: alpha(opacity=100) !important;
        }
        .steps-form .steps-row .steps-step .btn-circle {
          position: relative;
          width: 30px;
          height: 30px;
          text-align: center;
          padding: 6px 0;
          font-size: 12px;
          line-height: 1.428571429;
          border-radius: 15px;
          margin-top: 0;
        }
        .steps-form .steps-row .steps-step .btn-circle:before {
          content: '';
          position: absolute;
          top: 6.5px;
          left: 6.5px;
          width: 15px;
          height: 15px;
          border-radius: 50%;
          background: #fff;
        }
      </style>
    
      <div class="steps-form">
        <div class="steps-row setup-panel">
          <?php foreach ($locations as $key => $value): ?>
            <div class="steps-step">
              <span class="btn btn-circle <?= $key == $location ? 'btn-warning' : ($key < $location ? 'btn-success' : 'btn-primary') ?>"></span>
              <p><?= $value ?></p>
            </div>
          <?php endforeach ?>
        </div>
      </div>
    <?php
  };
