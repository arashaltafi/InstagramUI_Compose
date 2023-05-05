package com.arash.altafi.socialmedia.data

import com.arash.altafi.socialmedia.models.Post
import com.arash.altafi.socialmedia.models.Story
import com.arash.altafi.socialmedia.models.User

object MockData {

    private val users = ArrayList<User>()
    val stories = ArrayList<Story>()
    val posts = ArrayList<Post>()

    private const val caption: String =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Egestas purus viverra accumsan in nisl nisi. Arcu cursus vitae congue mauris rhoncus aenean vel elit scelerisque. In egestas erat imperdiet sed euismod nisi porta lorem mollis. Morbi tristique senectus et netus. Mattis pellentesque id nibh tortor id aliquet lectus proin. Sapien faucibus et molestie ac feugiat sed lectus vestibulum. Ullamcorper velit sed ullamcorper morbi tincidunt ornare massa eget. Dictum varius duis at consectetur lorem. Nisi vitae suscipit tellus mauris a diam maecenas sed enim. Velit ut tortor pretium viverra suspendisse potenti nullam. Et molestie ac feugiat sed lectus. Non nisi est sit amet facilisis magna. Dignissim diam quis enim lobortis scelerisque fermentum. Odio ut enim blandit volutpat maecenas volutpat. Ornare lectus sit amet est placerat in egestas erat. Nisi vitae suscipit tellus mauris a diam maecenas sed. Placerat duis ultricies lacus sed turpis tincidunt id aliquet."

    init {
        stories.add(Story("", "https://arashaltafi.ir/Social_Media/story-01.jpg", true))
        stories.add(Story("", "https://arashaltafi.ir/Social_Media/story-02.jpg", false))
        stories.add(Story("", "https://arashaltafi.ir/Social_Media/story-03.jpg", false))
        stories.add(Story("", "https://arashaltafi.ir/Social_Media/story-04.jpg", true))
        stories.add(Story("", "https://arashaltafi.ir/Social_Media/story-05.jpg", false))
        stories.add(Story("", "https://arashaltafi.ir/Social_Media/story-06.jpg", false))


        users.add(
            User(
                "arashaltafi",
                "Arash Altafi",
                "https://arashaltafi.ir/Social_Media/story-00.jpg"
            )
        )
        users.add(
            User(
                "alirezaei",
                "Ali Rezaei",
                "https://arashaltafi.ir/Social_Media/story-01.jpg"
            )
        )
        users.add(
            User(
                "arashaltafi",
                "Hasan Bahrami",
                "https://arashaltafi.ir/Social_Media/story-02.jpg"
            )
        )
        users.add(
            User(
                "abbasHeydari",
                "Abbas Heydari",
                "https://arashaltafi.ir/Social_Media/story-03.jpg"
            )
        )
        users.add(
            User(
                "jafarahmadi",
                "Jafar Ahmadi",
                "https://arashaltafi.ir/Social_Media/story-04.jpg"
            )
        )
        users.add(
            User(
                "hoseinmohebi",
                "Hosein Mohebi",
                "https://arashaltafi.ir/Social_Media/story-05.jpg"
            )
        )
        users.add(
            User(
                "mohammadalaee",
                "Mohammad Alaeei",
                "https://arashaltafi.ir/Social_Media/story-06.jpg"
            )
        )

        posts.add(
            Post(
                users[0],
                "Iran, Tehran",
                "https://arashaltafi.ir/Social_Media/story-00.jpg",
                caption
            )
        )
        posts.add(
            Post(
                users[1],
                "NewYork City",
                "https://arashaltafi.ir/Social_Media/story-01.jpg",
                caption
            )
        )
        posts.add(
            Post(
                users[2],
                "Iran",
                "https://arashaltafi.ir/Social_Media/story-02.jpg",
                caption
            )
        )
        posts.add(
            Post(
                users[3],
                "Tehran",
                "https://arashaltafi.ir/Social_Media/story-03.jpg",
                caption
            )
        )
        posts.add(
            Post(
                users[4],
                "USA",
                "https://arashaltafi.ir/Social_Media/story-04.jpg",
                caption
            )
        )
        posts.add(
            Post(
                users[5],
                "Los Angeles",
                "https://arashaltafi.ir/Social_Media/story-05.jpg",
                caption
            )
        )
        posts.add(
            Post(
                users[5],
                "iran",
                "https://arashaltafi.ir/Social_Media/story-06.jpg",
                caption
            )
        )

    }

}