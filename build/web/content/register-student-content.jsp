<body>
    <div class="container">

        <form class="well form-horizontal" action="./aplikacija" method="POST"  enctype="multipart/form-data" id="contact-form">
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
                    <label class="col-md-4 control-label">Country of origin</label>
                    <div class="col-md-4 selectContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-map-marker"></i></span>
                            <select name="country" class="form-control selectpicker">
                                <option value="">Select your Country</option>
                                <option value="Afghanistan">Afghanistan</option>
                                <option value="Syria">Syria</option>
                                <option value="Iran">Iran</option>
                                <option value="Lebanon">Lebanon</option>
                                <option value="Egypt">Egypt</option>
                                <option value="Pakistan">Pakistan</option>
                            </select>
                        </div>
                    </div>
                </div>
                
                <div class="form-group"> 
                    <label class="col-md-4 control-label">Mother tongue</label>
                    <div class="col-md-4 selectContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
                            <select name="language" class="form-control selectpicker">
                                <option value="">Select your language</option>
                                <option value="Pashto">Pashto</option>
                                <option value="Dari">Dari</option>
                                <option value="Arabic">Arabic</option>
                            </select>
                        </div>
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-md-4 control-label" >Date of birth</label> 
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                            <input name="dateOfBirth" placeholder="Date of birth" class="form-control"  type="date">
                        </div>
                    </div>
                </div>
                
                <div class="form-group">
                    <label class="col-md-4 control-label" >Profile photo</label> 
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-picture"></i></span>
                            <input class="btn btn-default" type="file" accept=".jpg, .png" name="studentPhoto"/><br/><br/>
                        </div>
                    </div>
                </div>
                
                <div class="file-upload">
                
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
            <input type="hidden" name="akcija" value="registrujUcenika" />
        </form>
    </div>
</div><!-- /.container -->
</body>