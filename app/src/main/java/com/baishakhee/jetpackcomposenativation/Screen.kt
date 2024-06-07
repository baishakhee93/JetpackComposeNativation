package com.baishakhee.jetpackcomposenativation

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.provider.Settings.ACTION_BLUETOOTH_SETTINGS
import android.provider.Settings.ACTION_DATE_SETTINGS
import android.provider.Settings.ACTION_DISPLAY_SETTINGS
import android.provider.Settings.ACTION_INPUT_METHOD_SETTINGS
import android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS
import android.provider.Settings.ACTION_WIFI_SETTINGS
import android.provider.Settings.ACTION_WIRELESS_SETTINGS
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

object Screen {


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun OtherScreen(navController: NavHostController) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Other Screen") },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.Default.Menu, contentDescription = "Back")
                        }
                    },
                    actions = {
                        // Add actions if needed
                    }
                )
            },
            content = {
                Text("Other Screen Content")
            }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ProfileScreen(navController: NavHostController) {

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
                            "Profile",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.White
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }

                    },

                    )
            },
            content = { innerPadding ->
                LazyColumn(
                    contentPadding = innerPadding,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.LightGray)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    item {
                        // Profile image
                        Image(
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "Profile Image",
                            modifier = Modifier
                                .size(100.dp)
                                .clip(shape = CircleShape)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Text
                        Text(
                            text = "User Name",
                            style = TextStyle(fontSize = 24.sp, color = Color.Black)
                        )
                        // Title
                        Text(
                            text = "Baishakhee",
                            style = TextStyle(
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            ),
                            modifier = Modifier.padding(bottom = 16.dp)
                        )// Text
                        Text(
                            text = "User Email ID",
                            style = TextStyle(fontSize = 24.sp, color = Color.Black)
                        )
                        // Title
                        Text(
                            text = "baishgakhee@gmail.com",
                            style = TextStyle(
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            ),
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        Text(
                            text = "User Mobile Number",
                            style = TextStyle(fontSize = 24.sp, color = Color.Black)
                        )
                        // Title
                        Text(
                            text = "91 0000000000",
                            style = TextStyle(
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            ),
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        Text(
                            text = "Address",
                            style = TextStyle(fontSize = 24.sp, color = Color.Black)
                        )
                        // Title
                        Text(
                            text = " India",
                            style = TextStyle(
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            ),
                            modifier = Modifier.padding(bottom = 16.dp)
                        )

                        Button(
                            onClick = { /* Handle button click */ },
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.appColor))
                        ) {
                            Text(text = "Edit")
                        }

                    }
                }
            }
        )

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun NotificationsScreen(navController: NavHostController) {
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
                            "Notifications",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.White
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }

                    },

                    )
            },
            content = { innerPadding ->
                LazyColumn(
                    contentPadding = innerPadding,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(10) { index ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                        ) {
                            Text("Notification $index", modifier = Modifier.padding(16.dp))
                        }
                    }

                }

            }
        )
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SettingsScreen(navController: NavController, context: Context) {


        Scaffold(
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = colorResource(id = R.color.appColor),
                        titleContentColor = MaterialTheme.colorScheme.primary,
                        actionIconContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ),
                    title = {
                        Text(
                            "Settings",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.White
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            },
            content = { innerPadding ->
                LazyColumn(
                    contentPadding = innerPadding,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    item {


                        // on below line we are adding a text for heading.
                        Text(
                            // on below line we are specifying text
                            text = "Settings in Android",
                            // on below line we are specifying text color,
                            // font size and font weight
                            color = colorResource(id = R.color.appColor), fontSize = 20.sp, fontWeight = FontWeight.Bold
                        )

                        // on below line adding a spacer.
                        Spacer(modifier = Modifier.height(20.dp))

                        // on below line creating a button
                        // to open settings screen.
                        Button(onClick = {
                            // on below line we are opening our intent
                            // for wireless settings screen.
                            val i = Intent(ACTION_WIRELESS_SETTINGS)
                            context.startActivity(i)
                        }, modifier = Modifier.width(300.dp)) {

                            // on below line adding a text for our button.
                            Text(text = "Open Wireless Settings", color = Color.White)
                        }

                        // adding spacer on below line.
                        Spacer(modifier = Modifier.height(10.dp))

                        // on below line creating a button to
                        // check battery charging status
                        Button(onClick = {
                            // on below line we are opening our
                            // intent for wifi settings screen.
                            val i = Intent(ACTION_WIFI_SETTINGS)
                            context.startActivity(i)
                        }, modifier = Modifier.width(300.dp)) {
                            // on below line adding a text for our button.
                            Text(text = "Wifi Settings", color = Color.White)
                        }

                        // adding spacer on below line.
                        Spacer(modifier = Modifier.height(10.dp))

                        // on below line creating a button to
                        // check battery charging status
                        Button(onClick = {
                            // on below line we are opening our intent
                            // for bluetooth settings screen.
                            val i = Intent(ACTION_BLUETOOTH_SETTINGS)
                            context.startActivity(i)
                        }, modifier = Modifier.width(300.dp)) {
                            // on below line adding a text for our button.
                            Text(text = "Open Bluetooth Settings", color = Color.White)
                        }

                        // adding spacer on below line.
                        Spacer(modifier = Modifier.height(10.dp))

                        // on below line creating a button to
                        // check battery charging status
                        Button(onClick = {
                            // on below line we are opening our
                            // intent for date settings screen.
                            val i = Intent(ACTION_DATE_SETTINGS)
                            context.startActivity(i)
                        }, modifier = Modifier.width(300.dp)) {
                            // on below line adding a text for our button.
                            Text(text = "Open Date Settings", color = Color.White)
                        }

                        // adding spacer on below line.
                        Spacer(modifier = Modifier.height(10.dp))

                        // on below line creating a button to check
                        // battery charging status
                        Button(onClick = {
                            // on below line we are opening our intent
                            // for input method settings screen.
                            val i = Intent(ACTION_INPUT_METHOD_SETTINGS)
                            context.startActivity(i)
                        }, modifier = Modifier.width(300.dp)) {
                            // on below line adding a text for our button.
                            Text(text = "Open Input Method Settings", color = Color.White)
                        }

                        // adding spacer on below line.
                        Spacer(modifier = Modifier.height(10.dp))

                        // on below line creating a button to
                        // check battery charging status
                        Button(onClick = {
                            val i = Intent(ACTION_DISPLAY_SETTINGS)
                            context.startActivity(i)
                        }, modifier = Modifier.width(300.dp)) {
                            // on below line adding a text for our button.
                            Text(text = "Open Display Settings", color = Color.White)
                        }

                        // adding spacer on below line.
                        Spacer(modifier = Modifier.height(10.dp))

                        // on below line creating a button to
                        // check battery charging status
                        Button(onClick = {
                            // on below line we are opening our intent
                            // for location settings screen.
                            val i = Intent(ACTION_LOCATION_SOURCE_SETTINGS)
                            context.startActivity(i)
                        }, modifier = Modifier.width(300.dp)) {
                            // on below line adding a text for our button.
                            Text(text = "Open Location Settings", color = Color.White)
                        }

                        // adding spacer on below line.
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }

        )
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun FavoriteScreen(navController: NavHostController) {

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
                            "Favorite",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.White
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }

                    },

                    )
            },
            content = { innerPadding ->
                LazyColumn(
                    contentPadding = innerPadding,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    items(10) { index ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                        ) {
                            Text("Favorite $index", modifier = Modifier.padding(16.dp))
                        }
                    }
                }
            },

            )


    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AboutUsScreen(navController: NavHostController) {
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
                            "About Us",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = Color.White
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }

                    },

                    )
            },
            content = { innerPadding ->
                LazyColumn(
                    contentPadding = innerPadding,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    item {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("Jetpack Compose")
                                }
                                append(" is a modern toolkit for building native Android UI. Jetpack Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.\n\n")
                                append(
                                    buildAnnotatedString {
                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                            append("Material Design")
                                        }
                                        append("\nCompose is built to support Material Design principles. Many of its UI elements implement Material Design out of the box. In this lesson, you'll style your app with Material Design widgets.")
                                    }
                                )
                            },
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }


        )

    }

    @Composable
    fun ShareScreen() {
        Text("AboutUsScreen ", modifier = Modifier.padding(16.dp))
    }

}


