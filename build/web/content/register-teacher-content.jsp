<body>
    <div class="container">

        <form class="well form-horizontal" action="./aplikacija" method="post"  id="contact-form">
            <fieldset>

                <!-- Form Name -->
                <legend><center><h2><b>Registration Form</b></h2></center></legend><br>

                <!-- Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label">First Name</label>  
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input  name="first-name" placeholder="First Name" class="form-control"  type="text" id="first-name">
                        </div>
                    </div>
                </div>

                <!-- Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label" >Last Name</label> 
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="last-name" placeholder="Last Name" class="form-control"  type="text" id="last-name">
                        </div>
                    </div>
                </div>

                <div class="form-group"> 
                    <label class="col-md-4 control-label">Country</label>
                    <div class="col-md-4 selectContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                            <select name="country" class="form-control selectpicker">
                                <option value="">Select your Country</option>
                                <option value="Germany">Germany</option>
                                <option value="Serbia">Serbia</option>
                                <option value="Hungary">Hungary</option>
                                <option value="Greece">Greece</option>
                                <option value="Turkey">Turkey</option>
                                <option value="Bulgaria">Bulgaria</option>
                                <option value="Romania">Romania</option>
                                <option value="Slovenia">Slovenia</option>
                                <option value="Croatia">Croatia</option>
                                <option value="Italy">Italy</option>
                                <option value="France">France</option>
                                <option value="Great Britain">Great Britain</option>
                                <option value="Norway">Norway</option>
                                <option value="Sweden">Sweden</option>
                                <option value="Finland">Finland</option>
                            </select>
                        </div>
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-md-4 control-label" >Educational institution name</label> 
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="institution" placeholder="Educational institution name" class="form-control"  type="text">
                        </div>
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label">E-Mail</label>  
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                            <input name="email" placeholder="E-Mail Address" class="form-control"  id="email-input" type="text">
                            <h5 id="result"></h5>
                        </div>
                    </div>
                </div>

                <!-- Success message -->
                <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i> Success!.</div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label"></label>
                    <div class="col-md-4"><br>
                        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<button type="button" onclick="validate()" class="btn btn-primary" id="registration-submit">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspSUBMIT <span class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</button>
                    </div>
                </div>
            </fieldset>
            <input type="hidden" name="akcija" value="registrujUcitelja" />
        </form>
    </div>
</div><!-- /.container -->
</body>