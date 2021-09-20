<div class="container">
    <div class="row">
    <div class="modal fade demo-popup" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel-1" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title">Formas de Pagamento</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                </div>
                <div class="modal-body">
                    
                    <div class="container">
                        <div class="row">
                            <div class="col col-sm pb-4 rounded border border-primary">
                                
                                <div class="d-flex flex-column flex-md-row align-items-center mt-2 mb-0">
                                    
                                    <div class="my-0 mr-md-auto">
                                        <h5>Produtos</h5>
                                    </div>

                                    <div class="my-2 my-md-0 mr-md-3 ml-3">
                                        <strong>Total:</strong> R$ <?php echo number_format($total,2,",",".");?>
                                    </div>

                                </div>

                                <hr class="mt-1 mb-2">

                                <?php
                                    foreach ($data as $item) {
                                        echo $item["nome"]."<br>";
                                    }
                                ?>
                            </div>

                            <div class="col-auto col-sm-auto pt-2">

                                <a class="btn btn-outline-warning" href="?con=masterCard,<?php echo $total?>">
                                    <img height="30px" src="https://upload.wikimedia.org/wikipedia/commons/b/b7/MasterCard_Logo.svg">
                                </a>

                                <!-- ... -->

                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
    </div>
</div>