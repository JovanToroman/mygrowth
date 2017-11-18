<body>
    <div class="container">
        <div class="col-md-5">
            <div class="form-area">  
                <form role="form" action="./aplikacija" method="POST">
                    <br style="clear:both">
                    <h3 style="margin-bottom: 25px; text-align: center;">We love hearing from you!</h3>
                    <div class="form-group">
                        <input type="text" class="form-control" id="name" name="name" placeholder="Name" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="email" name="email" placeholder="Email" required>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="subject" name="subject" placeholder="Subject" required>
                    </div>
                    <div class="form-group">
                        <textarea class="form-control" type="textarea" id="message" name="message" placeholder="Message" maxlength="140" rows="7"></textarea>
                        <span class="help-block"><p id="characterLeft" class="help-block ">You have 140 letters to enchant us</p></span>                    
                    </div>
                    <button type="submit" id="submit" name="submit" class="btn btn-primary pull-right">Send</button>
                    <input type="hidden" name="akcija" value="kontakt" />
                </form>
            </div>
        </div>
    </div>
</body>

