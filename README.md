# Food Recipes Application - Native Android Application

![main screen](https://github.com/bouchaib-massioui/FoodRecipes/blob/main/for_readme/food_recipes_icon.png)

## Description

The Recipe App is a native Android app made using Android Studio, Java - based. It is created so that users can create new account, sign in & out, make new recipes, edit/delete their info, and add pictures to them. 

**Note** : *all data (recipes) is sharable between local accounts*, ex. if *demo_user* create new recipe then the others local accounts will be able to visualize the same data as *demo_user*.

The app uttilizes Material Design.

## Technical 
- `adapters` : folder contains adapters for: database - directions - ingredients - main page - recipes - viewPager for a single recipe (Ingrediants, Directions). 
- `dao` : folder contains data access objects for: directions - ingredients - SQLiteDatabaseHelper - recipes - users (id, password, name, email). 
- `models` : folder contains classes to define a: database - direction - ingredient - recipe - user.
- `ui` : folder contains the fragments for the different cuisines and the activities.
- `utils` : folder contains snippets of code for various functionalities.
- `min-sdk` : FoodRecipes supports only the newest SDKs, starting from API Level **24** (*Android 7.0*) as **MinSdk**.

## Installation 
Recipe App has preconfigured user to grant endusers to browse the set of functionalities and utilities provided.
To use default user, please follow the underneath steps: 
- First of all, download the collection of used images from the follwoing url : [Here](https://github.com/bouchaib-massioui/FoodRecipes/tree/main/FoodRecipes/Images)
- On the device, paste the downloded images on **/Pictures/FoodRecipes/Images/**
- Run the Food Recipe App
- SignIn either by username(**demo_user**) or email(**demo_user@foodrecipes.com**) and password(**pwd123**): 

## Images
| ![](https://github.com/bouchaib-massioui/FoodRecipes/blob/main/for_readme/welcome.png) | ![](https://github.com/bouchaib-massioui/FoodRecipes/blob/main/for_readme/recipe_overview.jpg) |
|:---:|:---:|
| Welcome page  | Main window - Show food list |

| ![](https://github.com/bouchaib-massioui/FoodRecipes/blob/main/for_readme/signin_with_email.jpg) | ![](https://github.com/bouchaib-massioui/FoodRecipes/blob/main/for_readme/signin_with_username.jpg) |
|:---:|:---:|
| SignIn with Email | SignIn with username |

| ![](https://github.com/bouchaib-massioui/FoodRecipes/blob/main/for_readme/signup.jpg) | |
|:---:|:---:|
| SignUp | |

| ![](https://github.com/bouchaib-massioui/FoodRecipes/blob/main/for_readme/five_categories1.png) | ![](https://github.com/bouchaib-massioui/FoodRecipes/blob/main/for_readme/five_categories2.png) |
|:---:|:---:|
| The vertical ellipsis icon allows option to create new recipe/sign out | Edit or delete a single recipe |

| ![](https://github.com/bouchaib-massioui/FoodRecipes/blob/main/for_readme/app_shared_menu.jpg) | ![](https://github.com/bouchaib-massioui/FoodRecipes/blob/main/for_readme/recipe_menu.jpg) |
|:---:|:---:|
| Application use a shared menu | Shared recipe menu |

| ![](https://github.com/bouchaib-massioui/FoodRecipes/blob/main/for_readme/new_recipe.jpg) | ![](https://github.com/bouchaib-massioui/FoodRecipes/blob/main/for_readme/add_ingredients.jpg) | ![](https://github.com/bouchaib-massioui/FoodRecipes/blob/main/for_readme/add_directions.jpg) | ![](https://github.com/bouchaib-massioui/FoodRecipes/blob/main/for_readme/recipe_added.jpg) |
|:---:|:---:|:---:|:---:|
| New recipe | Add ingredients| Add directions| New recipe has been added|

| ![](https://github.com/bouchaib-massioui/FoodRecipes/blob/main/for_readme/update_recipe.jpg) | ![](https://github.com/bouchaib-massioui/FoodRecipes/blob/main/for_readme/update_ingrediants.jpg) | ![](https://github.com/bouchaib-massioui/FoodRecipes/blob/main/for_readme/update_directions.jpg) |
|:---:|:---:|:---:|
| Update recipe | Update ingredients| Update directions|
