Project: Record Store Sales Tracker
Development Team
Business Client: Chris Hopkins		
Lead Developer: Farhan
Quality Control: Fardin Sahriar Al Rafat

Description
Eclectic Echoes is a small, independent record store and this application will track the store’s sales.

Color
Main Color: #1E2A38 (Midnight Blue)
Secondary Color: #7DA1BF (Cool Slate Blue)
Accent Color: #F76C5E (Coral Red)

Required Fields
This will be a list of fields and their datatype (class design format). There are expected to be a minimum of six fields.
-id: int //primary key
-transactionDate: String Note: yyyy-MM-dd
-customerName: String
-albumTitle: String
-artistName: String
-formatType: String
-albumPrice: double
-giftWrapped: boolean
-subtotal: double
-totalCost: double

Calculation
Each transaction is for the purchase of one album.  The cost of the album (albumPrice) is determined by formatType which are stored in constants.  The same album on Vinyl, CD, or cassette will be priced differently.  However, every album is the same price based on the format.  The customer can choose to pay an additional fee of $2 if they would like the album gift wrapped.  The tax amount is a constant (taxRate) representing 15% sales tax. The prices are as follows:

Vinyl: $15
CD:  $10
Cassette: $5

subtotal = albumPrice + (giftWrapped ? giftWrapFee :  0)
totalCost = subtotal * (1 + taxRate)

Sample calculation:
A customer orders an album on vinyl and wants it giftwrapped.

 subtotal = 15 + (2)
totalCost = subtotal * (1 + taxRate) 
