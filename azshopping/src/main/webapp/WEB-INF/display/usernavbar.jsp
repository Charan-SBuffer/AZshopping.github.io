<nav class="navbar navbar-default">
	<div class="container"
		style="background-color: #cc33ff; font-style: italic">

		<ul class="nav navbar-nav">
			<li><a href="reqopenstudentpage" class="btn btn-info btn-lg">
					<span class="glyphicon glyphicon-home"></span>
			</a></li>

			<li><a href="reqlogout">LOGout</a></li>
			<li><a href="reqcartdetail">CART</a></li>
			<li><a href="reqabout">ABOUTus</a></li>
			<li><a href="reqorderhistory" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-th-list"></span> ORDERS
        </a></li>
        
			<li>
				<div class="dropdown">
					<button class="dropbtn">
					 <span class="glyphicon glyphicon-pencil"></span><i
							class="fa fa-caret-down"></i>
					</button>
					<div class="dropdown-content">
						<a href="reqchngpassword">CHANGE PASSWORD </a> <a
							href="reqchngshipingadd">CHANGE SHIPPINGADD</a> <a
							href="reqchngbilingadd">CHANGE BILLINGADD </a>
					</div>
				</div>
			</li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li>
				<div class="dropdown">
					<button class="dropbtn">
						<span class="glyphicon glyphicon-pencil"></span> <i
							class="fa fa-caret-down"></i>
					</button>
					<div class="dropdown-content">
						<a href="reqeditcustomer">EDIT PROFILE </a><br>
					</div>
				</div>
			</li>
			<li>				${customerobj.customername}	<br>	
			</li>
			<li>
			<img src="resources/images/customer/${customerobj.customerid }.jpg" width="50px" class="img-circle"/>
		</ul>
	</div>
</nav>

