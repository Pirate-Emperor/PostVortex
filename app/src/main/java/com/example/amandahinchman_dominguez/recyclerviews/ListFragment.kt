// Pirate-Emperor - Author
// This is a Kotlin Fragment class that displays a list of gaming-themed posts using RecyclerView

package com.example.gamingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*

// Data class representing an item in the list
data class Post(val title: String, val description: String, val imageUrl: String)

class ListFragment : Fragment() {

    // Sample data to be displayed in the RecyclerView with gaming topics
    private val postList = listOf(
        Post(
            "League of Legends Mix",
            "Exploring the Summoner's Rift.\n" +
            "Diving into the depths of League of Legends, where champions clash and strategies are forged. The thrill of securing a pentakill never gets old!",
            "https://static.wikia.nocookie.net/leagueoflegends/images/e/e6/League_of_Legends_Summoner%27s_Rift.jpg/revision/latest/scale-to-width-down/1000?cb=20210517134742"
        ),
        Post(
            
            "The Dark Knight Rises Again.",
            "Gotham's silent protector is back. Dive into the shadows with Batman as he faces off against his rogues' gallery in yet another thrilling adventure.",
            "https://www.rockpapershotgun.com/images/2021/01/batman-arkham-asylum.jpg"
        ),
        Post(
            
            "Swinging Through New York City.",
            "Experience the exhilarating freedom of web-swinging through New York as Spider-Man. Marvel's Spider-Man game brings the iconic superhero to life like never before.",
            "https://www.playstation.com/en-us/support/ps4/ps4-remote-play-setup-and-use/"
        ),
        Post(
            
            "League of Legends - Unleashing the Power of the Nexus.",
            "Join your team and destroy the enemy Nexus in this epic battle of wits and reflexes. Every decision counts in the world of Runeterra.",
            "https://www.mobafire.com/images/guide/9.16/lol-nexus-destruction.jpg"
        ),
        Post(
            
            "Arkham Asylum Awaits.",
            "Step into the shoes of the Caped Crusader as you navigate the twisted corridors of Arkham Asylum, battling some of the most notorious villains in the DC universe.",
            "https://www.theverge.com/2019/12/17/21028631/batman-arkham-asylum-remaster-release-date"
        ),
        Post(
            
            "Marvel's Spider-Man - A Hero's Journey.",
            "From swinging through skyscrapers to battling the sinister six, Marvel's Spider-Man delivers an unforgettable experience that every superhero fan should try.",
            "https://www.psu.com/wp-content/uploads/2021/09/marvels-spider-man-ps4-review-5.jpg"
        )
    )

    // Retain instance across configuration changes
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    // Inflate the fragment's layout
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main, container, false)

    // Set up RecyclerView with LinearLayoutManager and adapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = PostListAdapter(postList)
        }
    }

    // Factory method to create a new instance of the fragment
    companion object {
        fun newInstance(): ListFragment = ListFragment()
    }
}
