package com.baishakhee.jetpackcomposenativation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.baishakhee.jetpackcomposenativation.Screen.AboutUsScreen
import com.baishakhee.jetpackcomposenativation.Screen.FavoriteScreen
import com.baishakhee.jetpackcomposenativation.Screen.NotificationsScreen
import com.baishakhee.jetpackcomposenativation.Screen.ProfileScreen
import com.baishakhee.jetpackcomposenativation.Screen.SettingsScreen
import com.baishakhee.jetpackcomposenativation.ui.theme.JetpackComposeNativationTheme
import kotlinx.coroutines.launch

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeNativationTheme {
                val navController = rememberNavController()
                var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val context = applicationContext // Get the application context

                NavHost(navController, startDestination = "home") {
                    composable("home") {

                        GreetingContent(drawerState = drawerState, navController)
                    }
                    composable(Screens.ProfileScreen.route) {
                        ProfileScreen(navController)
                    }
                    composable(Screens.NotificationsScreen.route) {
                        NotificationsScreen(navController)
                    }
                    composable(Screens.FavoriteScreen.route) {
                        FavoriteScreen(navController)
                    }
                    composable(Screens.SettingsScreen.route) {
                        SettingsScreen(navController,context)
                    }
                    composable(Screens.AboutUsScreen.route) {
                        AboutUsScreen(navController)
                    }
                }


            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GreetingContent(drawerState: DrawerState, navController: NavHostController) {
    val cardItems = listOf(
        CardItem("Card 1", "This is the description for card 1."),
        CardItem("Card 2", "This is the description for card 2."),
        CardItem("Card 3", "This is the description for card 3.")
    )

    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    //  val items = listOf(Icons.Default.Close, Icons.Default.Clear, Icons.Default.Call)
    val items = listOf(
        Icons.Default.Home to "Home",
        Icons.Default.Person to "Profile",
        Icons.Default.Notifications to "Notifications",
        Icons.Default.Settings to "Settings",
        Icons.Default.Favorite to "Favorite",
        Icons.Default.Info to "About US",
        Icons.Default.Share to "Share",
    )
    val itemsBottom = listOf(
        Icons.Filled.Home to "Home",
        Icons.Filled.AccountCircle to "Account",
        Icons.Filled.AddCircle to "Add",
        Icons.Filled.Favorite to "Favorite",
        Icons.Filled.Settings to "Settings"
    )

    val screenDestinations = mapOf(
        "Home" to BottomNavigationScreen.HomeScreen,
        "Account" to BottomNavigationScreen.ProfileScreen,
        "Add" to BottomNavigationScreen.HomeScreen,
        "Favorite" to BottomNavigationScreen.FavoriteScreen,
        "Settings" to BottomNavigationScreen.SettingsScreen
    )
    var isFabVisible by remember { mutableStateOf(false) }

    // Mutable state to track the selected item
    val selectedItem = remember { mutableStateOf(items[0]) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            val coroutineScope = rememberCoroutineScope()

            ModalDrawerSheet {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorResource(id = R.color.appColor)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,

                    ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        // Profile image
                        Image(
                            painter = painterResource(id = R.drawable.baseline_person_pin_24),
                            contentDescription = "Profile Image",
                            modifier = Modifier
                                .size(100.dp)
                                .clip(shape = CircleShape)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        // Text
                        Text(text = " Baishakhee", color = colorResource(id = R.color.textColorDark))
                    }
                }

                Spacer(Modifier.height(12.dp))
                items.forEach { (icon, title) ->
                    NavigationDrawerItem(
                        icon = { Icon(icon, contentDescription = null) },
                        label = { Text(title) },
                        selected = false,
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            // Navigate to the corresponding screen when item clicked
                            val destination = Screens.routeFromTitle(title)
                            destination?.let { navController.navigate(it) }
                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }

            }


        },
        content = {

            Scaffold(
                topBar = {
                    TopAppBar(
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = colorResource(id = R.color.appColor),
                            titleContentColor = MaterialTheme.colorScheme.primary,
                            actionIconContentColor = Color.White,
                            navigationIconContentColor = Color.White,


                            ),
                        title = {
                            Text(
                                "",
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        },
                        navigationIcon = {
                            IconButton(onClick = { scope.launch { drawerState.open() } }) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "Localized description"
                                )
                            }
                        },
                        actions = {
                            IconButton(onClick = {
                                scope.launch {
                                    navController.navigate("Notifications")
                                }
                            }) {
                                Icon(Icons.Default.Notifications, contentDescription = "Profile")
                            }
                        },
                    )
                },

                content = { innerPadding ->
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        contentPadding = innerPadding,
                        verticalArrangement = Arrangement.spacedBy(8.dp) ,
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(8.dp)

                        ) {

                        items(cardItems) { cardItem ->
                            CardItem(cardItem = cardItem)
                        }


                    }
                },
                floatingActionButton = {
                    if (isFabVisible) {
                        FloatingActionButton(
                            onClick = {  },
                            containerColor = colorResource(id = R.color.appColor),
                            contentColor = Color.White,
                            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                        ) {
                            Icon(Icons.Filled.Add, "Localized description")
                        }
                    }


                },
                bottomBar = {
                    BottomAppBar(
                        modifier = Modifier.fillMaxWidth(),
                        contentColor = Color.Gray, // Default color for unselected icons
                        containerColor = Color.White,
                        tonalElevation = 50.dp

                    ) {
                        Card(modifier = Modifier.fillMaxWidth(),
                            ) {
                            Row(modifier = Modifier.fillMaxWidth()) {


                                // Iterate through each item in the list
                                itemsBottom.forEach { (icon, title) ->
                                    // Create an IconButton for each item
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        IconButton(
                                            onClick = {
                                                // Handle item click
                                                // Set the selected item
                                                selectedItem.value = icon to title
                                                // Navigate to the corresponding screen when item clicked
                                                val destination = screenDestinations[title]
                                                destination?.let { navController.navigate(it.route) }

                                            },
                                            // Set the content color based on whether the item is selected or not
                                            content = {
                                                Icon(
                                                    imageVector = icon,
                                                    contentDescription = title,
                                                    tint = if (icon == selectedItem.value.first) {
                                                        colorResource(id = R.color.appColor) // Change the color for selected icon
                                                    } else {
                                                        Color.Gray // Default color for unselected icons
                                                    }
                                                )

                                            }
                                        )
                                        // Add text below the icon
                                        Text(
                                            text = title,
                                            style = MaterialTheme.typography.bodyMedium,
                                            color = if (icon == selectedItem.value.first) {
                                                colorResource(id = R.color.appColor) // Change the color for selected text
                                            } else {
                                                Color.Gray // Default color for unselected text
                                            }
                                        )
                                    }
                                    // Add a Spacer between icons
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                            }
                        }
                    }

                },
            )
        }
    )


}
data class CardItem(val title: String, val description: String)

@Composable
fun CardItem(cardItem: CardItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        //elevation =
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = cardItem.title, style = MaterialTheme.typography.headlineLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = cardItem.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

