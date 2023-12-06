package com.example.javacookbookproject;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;

public class DBHandler extends SQLiteOpenHelper{
    //set name of database to be used
    private static final String NAME = "cookbook";

    //set current database version

    private static final int VERSION = 1;

    //set table name for recipes
    private static final String RECIPE_TABLE = "recipes";

    //set recipe ID column name
    private static final String ID_COLUMN = "id";

    //set name column name
    private static final String NAME_COLUMN = "name";

    //set ingredients column name
    private static final String INGREDIENTS_COLUMN = "ingredients";

    //set instructions column name
    private static final String INSTRUCTIONS_COLUMN = "instructions";

    //set favorite column name
    private static final String FAVORITE_COLUMN = "favorite";

    //constructor
    public DBHandler(Context context)
    {
        super(context,NAME,null,VERSION);
    }

    //create the database
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //making query to be run
        String query = "create table " + NAME + " (" + ID_COLUMN + " integer primary key autoincrement, " + NAME_COLUMN + " text," + INGREDIENTS_COLUMN + " text," +INSTRUCTIONS_COLUMN + " text," +FAVORITE_COLUMN + " integer)";

        //run the query
        db.execSQL(query);

        //set the database to contain these recipes by default
        addRecipeInternal(db,"Chocolate Chip Pancakes", "1 1/2 cup all-purpose flour\n4 tsp baking powder\n1/2 tsp salt\n2 Tbs sugar\n1 1/4 cup milk\n1 egg beaten\n3 Tbs butter melted\n1 tsp vanilla\n1 cup chocolate chips any flavor", "1. Whisk together flour, baking powder, salt and sugar until combined.\n2. In another bowl whisk together milk, egg, butter and vanilla.\n3. Fold or whisk in your wet ingredients into your dry ingredients until just combined.\n4. Then fold in your chocolate chips, batter may be lumpy and that is ok.\n5. Let the batter rest for about 5 minutes.\n6. Heat a non-stick skillet on stove over medium-high heat and spray with non-stick cooking spray.\n7. Pour or scoop the batter onto the pan in 1/4 cup measurements, gently spread the batter out some then press chocolate chips into the batter.\n8. Cook on each side for about 3-4 minutes until you see bubbles form and burst on top of batter, and the underside is golden.\n9. Flip until browned on other side, remove to plate to repeat until all batter is used.", 1);
        addRecipeInternal(db,"Chocolate Mousse", "1 cup chocolate chips\n½ cup heavy whipping cream, for melting chocolate chips\n⅔ cup chilled heavy whipping cream, for whipping\n1 tablespoon powdered sugar\n¼ teaspoon pure vanilla extract", "1. In a large bowl, heat chocolate chips and ½ cup cream until the chocolate is melted and the mixture is smooth. I do this in the microwave in 20 seconds increments, stirring well between each. Set aside to cool to room temperature, stirring occasionally (this took about 15 minutes).\n2. In the bowl of a hand mixer or stand mixer fitted with the whisk attachment, beat ⅔ cups chilled cream with powdered sugar and vanilla until stiff peaks form (see note about making extra for topping). Transfer the whipped cream to the refrigerator until the chocolate has cooled to room temperature.\n3. Using a rubber/silicone spatula, fold* the whipped cream into the melted chocolate. Once fully combined, transfer the mousse into individual serving dishes and chill for at least 2 hours. The colder it is, the more firm it will be. If you'd like it softer you can leave it at room temperature for about 15 minutes before serving", 0);
        addRecipeInternal(db,"Creamy Tomato Rigatoni", "1/4 cup unsalted butter\n1 cup chopped yellow onion\n1 (28-ounce) can whole peeled plum tomatoes, tomatoes crushed by hand and juices reserved\n12 ounces uncooked rigatoni pasta\n1/2 cup heavy cream\n1 teaspoon kosher salt\n1/4 teaspoon black pepper\n1/4 teaspoon crushed red pepper\n1/2 ounce Parmesan cheese, grated\nChopped fresh flat-leaf parsley, for garnish", "1. Melt butter in a large Dutch oven over medium. Add onion; cook, stirring occasionally, until tender and golden brown, about 5 minutes.\n2. Add tomatoes and their juices; bring to a boil over medium.\n3. Reduce heat to medium-low; simmer, stirring occasionally, until flavors meld and sauce thickens, about 30 minutes.\n4. Meanwhile, cook pasta in salted water according to package directions for al dente. Drain pasta, reserving 1/2 cup pasta cooking liquid.\n5. Stir cream, salt, black pepper, and crushed red pepper into tomato sauce. Add cooked pasta and toss to coat.\n6. Add reserved pasta cooking liquid, 1/4 cup at a time, until desired consistency is reached.\n7. Divide pasta evenly among 4 bowls; sprinkle with Parmesan and garnish with parsley.", 1);
        addRecipeInternal(db,"Brownies", "10 tablespoons salted butter melted\n1 cup granulated sugar\n2 large eggs\n2 teaspoons vanilla extract\n1/2 cup melted milk chocolate chips\n3/4 cup all-purpose flour\n1/4 cup unsweetened cocoa powder\n1/2 teaspoon salt\n1 cup milk chocolate chips", "1. Preheat oven to 350 degrees F. Line a metal 9x9 pan with parchment paper.\n2. Pour melted butter into a large mixing bowl. Whisk in sugar by hand until smooth, 30 seconds.\n3. Add in eggs and vanilla extract. Whisk 1 minute.\n4.Whisk in melted chocolate until combined and smooth.\n5. Use a rubber spatula to stir in flour, cocoa powder, and salt until just combined. Stir in whole chocolate chips.\n6. Pour into prepared pan and smooth out.\n7. Bake in the preheated oven for 30 minutes. Let cool in pan 30 minutes before slicing.", 0);

    }

    //used to add recipe to db
    public void addRecipe(String name, String ingredients, String instructions, int favorite)
    {
        //variable for the database
        SQLiteDatabase db = this.getWritableDatabase();

        //variable for the values to be inserted
        ContentValues vals = new ContentValues();

        //populate vals var
        vals.put(NAME_COLUMN,name);
        vals.put(INGREDIENTS_COLUMN,ingredients);
        vals.put(INSTRUCTIONS_COLUMN,instructions);
        vals.put(FAVORITE_COLUMN,favorite);

        //interact with the database
        db.insert(NAME,null,vals);

        //close connection
        db.close();
    }
//function used to have the database start with certain values
    public void addRecipeInternal(SQLiteDatabase dat, String name, String ingredients, String instructions, int favorite)
    {
        //variable for the database
        SQLiteDatabase db = dat;

        //variable for the values to be inserted
        ContentValues vals = new ContentValues();

        //populate vals var
        vals.put(NAME_COLUMN,name);
        vals.put(INGREDIENTS_COLUMN,ingredients);
        vals.put(INSTRUCTIONS_COLUMN,instructions);
        vals.put(FAVORITE_COLUMN,favorite);

        //interact with the database
        db.insert(NAME,null,vals);

        //close connection
        //db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer)
    {
        db.execSQL("drop table if exists " + RECIPE_TABLE);
        onCreate(db);
    }



    public Recipe getRecipe(int id)
    {
        //making a database object to interact with
        SQLiteDatabase db = this.getReadableDatabase();

        //making cursor to read from db
        Cursor cursor = db.rawQuery("select * from " + NAME + " where " + ID_COLUMN + "=" + id,null);

        //get data from cursor
        cursor.moveToFirst();

        String name = cursor.getString(cursor.getColumnIndexOrThrow(NAME_COLUMN));
        String ingredients = cursor.getString(cursor.getColumnIndexOrThrow(INGREDIENTS_COLUMN));
        String instructions = cursor.getString(cursor.getColumnIndexOrThrow(INSTRUCTIONS_COLUMN));
        int favoriteInt = cursor.getInt(cursor.getColumnIndexOrThrow(FAVORITE_COLUMN));

        boolean favorite;
        if (favoriteInt==1)
        {
            favorite = true;
        }
        else {
            favorite = false;
        }

        cursor.close();
        //Just haven't really figured out images with a database if I want color so... I know it isn't great, but it's WIP
        if (id == 1)
        {
            Recipe val = new Recipe(id,name,ingredients,instructions,favorite,R.drawable.chocolatechippancakesjava);
            return val;
        }
        else if (id==2)
        {
            Recipe val = new Recipe(id,name,ingredients,instructions,favorite,R.drawable.chocolatemoussejava);
            return val;
        }
        else if (id==3)
        {
            Recipe val = new Recipe(id,name,ingredients,instructions,favorite,R.drawable.rigatonijava);
            return val;
        }
        //should be else here but java needs that return out of the if statement
        Recipe val = new Recipe(id,name,ingredients,instructions,favorite,R.drawable.browniesjava);
        return val;
    }



}
