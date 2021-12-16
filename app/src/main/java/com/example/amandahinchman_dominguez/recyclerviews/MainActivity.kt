// Pirate-Emperor - Author
// This is the main activity class that hosts the ListFragment in a gaming application.

package com.example.gamingapp

// MainActivity class that extends SingleFragmentActivity to host a single fragment
class MainActivity : SingleFragmentActivity() {
    
    // Creates and returns an instance of ListFragment
    override fun createFragment() = ListFragment.newInstance()
}
