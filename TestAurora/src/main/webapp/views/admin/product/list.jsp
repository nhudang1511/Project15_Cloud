<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp"%>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
    <link href="<c:url value = "templates/css/style.css" />" rel="stylesheet" type="text/css">

<div class="container-fluid">
	<div class="row">
	 <nav class="col-md-2 d-none d-md-block bg-light sidebar">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item">
                <a class="nav-link active" href="#">
                  <span data-feather="home"></span>
                  Dashboard <span class="sr-only">(current)</span>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="order">
                  <span data-feather="file"></span>
                  Orders
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="product?cid=0">
                  <span data-feather="shopping-cart"></span>
                  Products
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="users"></span>
                  Customers
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="bar-chart-2"></span>
                  Reports
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="layers"></span>
                  Integrations
                </a>
              </li>
            </ul>

            <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
              <span>Saved reports</span>
              <a class="d-flex align-items-center text-muted" href="#">
                <span data-feather="plus-circle"></span>
              </a>
            </h6>
            <ul class="nav flex-column mb-2">
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="file-text"></span>
                  Current month
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="file-text"></span>
                  Last quarter
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="file-text"></span>
                  Social engagement
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="file-text"></span>
                  Year-end sale
                </a>
              </li>
            </ul>
          </div>
        </nav>
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
		<%@include file="/common/info.jsp"%>
		<h2>Quản Lý Sản Phẩm</h2>
		<div class="col-md-6">
		<form action="#" method="post" enctype="multipart/form-data">
			<div class="form-group" hidden="">
				<label for="productId">Product ID:</label> 
				<input type="text" name="id" value="${product.id}" id="productId" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="image">Image:</label> 
				<input type="file" class="form-control" name="image" id="image" value="${product.image}" />
			</div>
			<div class="form-group">
				<label for="categoryid">Category Id:</label> 
				<input type="text" class="form-control" name="idcategory" id="categoryid" value="${product.idcategory}" />
			</div>
			<div class="form-group">
				<label for="productname">Product Name:</label> 
				<input type="text" class="form-control" name="name" id="productname" value="${product.name}" />
			</div>
			<div class="form-group">
				<label for="originalPrice">Original Price:</label> 
				<input type="text" class="form-control" name="originalPrice" id="originalPrice" value="${product.originalPrice}" />
			</div>
			<div class="form-group">
				<label for="salePrice">Sale Price:</label> 
				<input type="text" class="form-control" name="salePrice" id="salePrice" value="${product.salePrice}" />
			</div>
			<div class="form-group">
				<label for="quantity">Quantity:</label> 
				<input type="text" class="form-control" name="quantity" id="quantity" value="${product.quantity}" />
			</div>
			<div class="form-group">
				<label for="discription">Describe:</label> 
				<input type="text" class="form-control" name="discription" id="discription" value="${product.discription}" />
			</div>
			<div class="form-check form-check-inline">
				<label for="active">Status:</label> 
				<input id="activeon" class="form-check-input" type="radio" name="active" ${product.active?'checked':''} value="true"> 
				<label for="activeon" class="form-check-label">Hoạt động</label>
				<br>
				<input id="activeoff" class="form-check-input" type="radio" name="active" ${!product.active?'checked':''} value="false"> 
				<label for="activeoff" class="form-check-label">Khóa</label>
			</div>
			<hr>
			<div class="form-group">
				<button class="btn btn-success" formaction="<c:url value="/admin/product-create"/>"> Create <i class="fa fa-plus"></i></button>
				<button class="btn btn-warning" formaction="<c:url value="/admin/product-update"/>"> Update <i class="fa fa-edit"></i></button>
				<%-- <button class="btn btn-danger" formaction="<c:url value="/admin/category-delete"/>"> Delete <i class="fa fa-trash"></i></button> --%>
				<button class="btn btn-success"formaction="${pageContext.request.contextPath }/admin/product-reset">Reset <i class="fa fa-undo"></i></button>
			</div>
		</form>
		</div>
		<!-- <div class="row">
             <div class="col-sm-12">
                 <a class="btn btn-info " data-toggle="modal" data-target="#editUser">Create</a>
             </div>
          </div> -->
          <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover" id="sample_2">
				<thead>
					<tr>
						<th>Mã sản phẩm</th>
						<th>Tên Sản Phẩm</th>
						<th>Giá gốc</th>
						<th>Giá bán</th>
						<th>Tình trạng</th>
						<th>Hành động</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${products}">
						<tr class="odd gradeX">
							<%-- <td><c:url value="/image?fname=category/${item.images!=null?item.images:'uploads/abc.jpg'}" var="imgUrl"></c:url> <img width="50px" height="50px" src="${imgUrl}"></td> --%>
							<td>${item.id}</td>
							<td><c:url value="/image?fname=product/${item.image!=null?item.image:'uploads/abc.jpg'}" var="imgUrl"></c:url><img width="50px" height="50px" src="${imgUrl}"> ${item.name}</td>
							<td>${item.originalPrice}</td>
							<td>${item.salePrice}</td>
							<td>
							<c:if test="${item.active == true}"><span class="label label-sm label-success"> Hoạt động </span></c:if> 
							<c:if test="${item.active == false}"><span class="label label-sm label-warning"> Khóa </span></c:if>
							</td>
							<%-- <td><button class="btn btn-warning"><a href="<c:url value='/admin/category-edit?categoryId=${item.id}'/>" class="center"> Edit</a><i class="fa fa-edit"></i></button>
								<button class="btn btn-danger" data-toggle="modal" data-target="#editUser"><a href="<c:url value='/admin/category-delete?categoryId=${item.id}'/>">Delete</a><i class="fa fa-edit"></i></button>
							</td> --%>
							<td><a href="<c:url value='/admin/product-edit?productId=${item.id}'/>" class="center">Edit</a> | <a
								href="<c:url value='/admin/product-delete?productId=${item.id}'/>" class="center">Delete</a></td>
						</tr>
						
					</c:forEach>
				</tbody>
			</table>
          </div>
          <div id="editUser" class="modal fade">
				            <div class="modal-dialog">
				                <div class="modal-content">
				                    <form action="/admin/category-delete?categoryId=${item.id}" method="post" enctype="multipart/form-data">
				                        <div class="modal-header">						
				                            <h4 class="modal-title">${category.categoryname}</h4>
				                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				                        </div>
				                        <div class="modal-body">	
				                            <div class="form-group">
				                                <a>Bạn có chắc chắn muốn xóa?</a>
				                            </div>
				                        </div>
				                        <div class="modal-footer">
				                        	<input type="button" class="btn btn-primary" value="/admin/category-delete?categoryId=${item.id}">Yes</button>
				                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
				                        </div>
				                    </form>
				                </div>
				            </div>
        				</div>
			<%-- <div class="col-md-12">
				<!-- BEGIN EXAMPLE TABLE PORTLET-->
				<div class="portlet box grey-cascade">
					<div class="portlet-body">
						<div class="table-toolbar">
							<!-- Hiển thị thông báo -->
							<%@include file="/common/info.jsp"%>
							<!-- Kết thúc hiển thị thông báo -->
							<div class="row"> --%>
								<%-- <div class="col-md-3">
									<div class="row">
										<div class="col-md-9">
											<form action="#" method="post" enctype="multipart/form-data">
												<br />
												<div class="form-group" hidden="">
													<label for="categoryId">Category ID:</label> <input type="text"
														name="id" value="${category.id}"
														id="categoryId" class="form-control"/>
												</div>
												<div class="form-group">
													<label for="categoryname">Category Name:</label> <input
														type="text" class="form-control" name="categoryname" id="categoryname" value="${category.categoryname}" />
												</div>
												<br />
												<hr>
												<div class="form-group">
													<button class="btn green"
														formaction="<c:url value="/admin/category-create"/>">
														Create <i class="fa fa-plus"></i>
													</button>
													<button class="btn btn-warning"
														formaction="<c:url value="/admin/category-update"/>">
														Update <i class="fa fa-edit"></i>
													</button>
													<br /> <br />
													<button class="btn btn-danger"
														formaction="<c:url value="/admin/category-delete"/>">
														Delete <i class="fa fa-trash"></i>
													</button>
													<button class="btn btn-success"
														formaction="${pageContext.request.contextPath }/admin/category-reset">
														Reset <i class="fa fa-undo"></i>
													</button>
												</div>
											</form>
										</div>
									</div>
								</div> --%>
								<%-- <div class="col-md-12" style="padding-right: 25px">
									<div class="row">
										<div class="col-md-6"></div>
										<div class="col-md-6">
											<div class="btn-group pull-right">
												<button class="btn dropdown-toggle" data-toggle="dropdown">
													Tools <i class="fa fa-angle-down"></i>
												</button>
												<ul class="dropdown-menu pull-right">
													<li><a href="#"> Print </a></li>
													<li><a href="#"> Save as PDF </a></li>
													<li><a href="#"> Export to Excel </a></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="table-responsive">
										<table class="table table-striped table-sm"
											id="sample_2">
											<thead>
												<tr>
													<th>Mã danh mục</th>
													<th>Tên danh mục</th>
													<th>Hành động</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${categorys}">
													<tr class="odd gradeX">
														<td>${item.id}</td>
														<td>${item.categoryname}</td>
														<td><a
															href="<c:url value='/admin/category-edit?categoryId=${item.id}'/>"
															class="center">Edit</a> | <a
															href="<c:url value='/admin/category-delete?categoryId=${item.id}'/>"
															class="center">Delete</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										</div>
									</div>
								</div> --%>
			<!-- 				</div>
						</div>
					</div>
				</div>
				END EXAMPLE TABLE PORTLET
			</div> -->
		</main>
		
		   <!-- Modal -->

 		<%-- <div id="editUser" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="#" method="post" enctype="multipart/form-data">
                        <div class="modal-header">						
                            <h4 class="modal-title">Edit Category</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        
                        <div class="modal-body">	
                            <div class="form-group" hidden="">
                                <label>Id</label>
                                <input name="id" value="${category.id}" type="text" class="form-control" readonly>
                            </div>				
                            <div class="form-group">
                                <label>Name category</label>
                                <input name="categoryname" value="${category.categoryname}"  type="text" class="form-control" required>
                            </div>
                            
                        </div>
                        <div class="modal-footer">
                        	<button class="btn btn-success" formaction="<c:url value="/admin/category-create"/>">Create <i class="fa fa-plus"></i></button>
                        	<button class="btn btn-warning" formaction="<c:url value="/admin/category-update"/>">Update <i class="fa fa-edit"></i></button>
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" formaction="<c:url value="/admin/category-create"/> value="Edit">
                        </div>
                    </form>
                </div>
            </div>
        </div> --%>
</div>
</div>