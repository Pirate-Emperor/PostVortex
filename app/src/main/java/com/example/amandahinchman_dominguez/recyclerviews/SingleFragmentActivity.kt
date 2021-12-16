// Pirate-Emperor - Author
// This is a Kotlin abstract class for hosting a single fragment in an activity, commonly used in gaming applications.

package com.example.gamingapp

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

// Abstract class to manage a single fragment in an activity
abstract class SingleFragmentActivity : AppCompatActivity() {

    // Provides the layout resource ID for the activity
    private val layoutResId: Int
        @LayoutRes
        get() = R.layout.activity_fragment

    // Abstract method to create and return the fragment instance
    protected abstract fun createFragment(): Fragment

    // Called when the activity is starting
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view to the specified layout
        setContentView(layoutResId)

        // Get the FragmentManager to manage fragments
        val fragmentManager = supportFragmentManager
        var fragment = fragmentManager.findFragmentById(R.id.fragment_container)

        // If no fragment is currently added, create and add the fragment
        if (fragment == null) {
            fragment = createFragment()
            fragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }
}
