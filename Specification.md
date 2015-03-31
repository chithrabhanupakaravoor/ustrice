## System Specification and Requirement ##

  1. [Log in](Specification#1._Log_in.md)
  1. [Home Page](Specification#2._Home_Page.md)
  1. [Ordering Menu](Specification#3._Ordering_Menu.md)
  1. [Food Recommendation](Specification#4._Food_Recommendation.md)
  1. [Preferences](Specification#5._Preferences.md)
  1. [Ranking](Specification#6._Ranking.md)
  1. [User Profile](Specification#7._User_Profile.md)
  1. [Tools](Specification#8._Tools.md)


---


### 1. Log in ###

  * A database is built to store all the users' data
  * Users need to log in to the system by using users' account and password

### 2. Home Page ###

  * In the home page, i.e. the page after log in, it will be advertisements from different canteens, with photo of dishes and price, scrolling left and right will give advertisements from other canteens. It will automatically scroll from left to right every 4 seconds.
  * At the bottom, there will be buttons for different functions and pages, they will stay at the bottom for each pages.
    1. Home – returning to home page
    1. Menu – ordering food and viewing menu
    1. Recommendation – recommending food choices for users
    1. Preferences – viewing and editing user’s preference
    1. Ranking – showing the food ranking
    1. User Profile – viewing and editing user’ profile

### 3. Ordering Menu ###

  * Menu Page:
    1. On the top of the screen, there is a bar for typing in key words to search foods.
    1. Type of food could be selected under it in order to filter them, option divided by “canteen”, “cuisine”, “dish”, and “price”.
    1. The choices will be displayed in 4 bars, and sliding them left and right to choose the type of food.
    1. Pressing the “filter” button will then filter the choices and go to the next page which is a list of food choices.

  * List Page:
    1. A list of food will be displayed with photos, name, rating and prices, within a rectangular box.
    1. On the left of the box, there is a star button which users can click on it to set as favorite, or click on it once again to remove from favorite.
    1. While in this page, there is a floating dialog box at the bottom which will show the order users have made temperately but not paid yet.

  * Food Page:
    1. By clicking on the foods in the list page, details of the food selected will be given.
    1. On the top left corner, a “Back” button is for returning to the previous page, i.e. the list page.
    1. Picture of the food and basic information of it, the four types in the menu page, will be shown on the next row, with picture on the left and information on the right.
    1. Nutrition value such as carbohydrates, fats, proteins, calories, fibre, etc. will be shown below of the picture.
    1. Under it, there is the rating and comments of this food which users of this app give.
    1. Three buttons are on the bottom of this page, from left to right, is “add to my favorite”, “save to my order list”, and “view my order list” which will pop up a dialog box and show the order list.

### 4. Food Recommendation ###

  * If users are frustrated with making decision of what to eat, this would be a great feature to assist him. With this advisor, the choices could be minimize into 3 only, using "Ranking", "Diet" or "Nutrition" option. If 3 choices are still too much, "Shake" function could even make the selection much faster, as users could get the only one recommendation which is also the best one by simply shaking the phone. "Food Recommendation" not only shortens the decision time but also choose the best food wisely for the customers.
    1. **"Ranking" button** - Top 3 of the week would be shown. This option is well-designed for those who are looking for the food has guaranteed delicious.
    1. **"Diet" button** - As the pattern of user’s diet would be stored by the system, 3 choices would be given out according to which type of food the user will most likely want to eat. For example, if the user eats Chinese BBQ quite often, the system will suggest the same type but may not be the same item he eat most.
    1. **"Nutrition" button** - To help customers maintain a healthy lifestyle, this option selects the foods which could balance their diet. For instance, if the user eat too much fat in this week, such as fried food, the system will recommend the food with less fat or may be contains more vegetables.
    1. **"Shake" button** - By shaking the phone, the best answer would be calculated by referring to the 3 criteria above plus a hidden formula.

  * _Note: if one specific food was ordered by the user too often in a short period of time, it would not be counted. We prefer the user can have a more variety of food choice._

  * **Once the choice is confirmed, it will proceed to the ordering and payment.**

### 5. Preferences ###

  * This function can save a list of 10 items.
  * The list will be shown as the List Page in Order Menu

### 6. Ranking ###

  * Besides food ordering and recommendation, the system could also create the statistics on which foods are most ordered and rated. Both customers and the canteen could gain the benefits by looking the charts.
    1. **For customers** - Sometimes customers may not know which item taste good or which one is not quite worth to spend money, especially for the new items. By the ranking system, customers could know which foods are guaranteed.
    1. **For canteens** - By collecting all the statistical data, canteen managers could know what customers like and dislike. Therefore, they could improve the menus which could attract more customers.

  * Settings for the user to amend the ranking list:
    1. **Most ordered** - the ranking list is sorted by the number of item was ordered within a period.
    1. **Most rated** - the ranking list is sorted by the rating given by customers within a period.
    1. **Set period** – the user could customize the period. E.g. 1 day, 1 week or 1 month.

  * _Note: The user could order the food by clicking on the item._


### 7. User Profile ###

  * This function will show all the user information and divide the interface into four parts:
    1. On the top-left corner of the screen, it is the profile picture of the user.
    1. On the top-right corner of the screen, some basic information will be shown, including user name, user ID, Balance in this account.
    1. On the body part, there is a list of record which is up to 10 days past orders being shown in a table.
    1. At the bottom, it is a button that links to a dialog box for users to change their user name and password.

### 8. Tools ###

  * Tools used in this project: Android SDK, Eclipse Java, SQL