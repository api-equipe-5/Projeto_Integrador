<div id="carouselIndicators" class="carousel slide w-75 h-75" data-ride="carousel">
    <ol class="carousel-indicators">
        <?php 
            for($x=0;$x<$count;$x++){
                echo "<li data-target='#carouselIndicators' data-slide-to='$x' ";if($x<1){echo "class='active'";} echo "></li>";
            }
        ?>
    </ol>
    <div class="carousel-inner">
        <?php
            for($x=0;$x<$count;$x++){
                echo"
                <div class='carousel-item active'>
                    <img class='d-block w-100 h-100 rounded' src='imagens/".$img[$x]."' alt='slide-".$x."'>
                    <div class='carousel-caption d-none d-md-block ml-md-5 mr-md-5 bg-dark text-light rounded-pill'>
                        <h5>".$nome[$x]."</h5>
                        <p>".$descrip[$x]."</p>
                    </div>
                </div>
                ";
            }
        ?>
    </div>
    