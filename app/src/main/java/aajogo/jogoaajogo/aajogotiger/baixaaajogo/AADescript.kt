package aajogo.jogoaajogo.aajogotiger.baixaaajogo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import aajogo.jogoaajogo.aajogotiger.baixaaajogo.databinding.ActivityAadescriptBinding

class AADescript : AppCompatActivity() {
    lateinit var b_desc: ActivityAadescriptBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        b_desc = ActivityAadescriptBinding.inflate(layoutInflater)
        setContentView(b_desc.root)
        b_desc.desc.setText("In Crystallis, you find yourself in a land where crystal shards have been scattered across the land, their radiant glow illuminating the once-dark corners of the world. These crystals possess astonishing abilities, ranging from healing and restoration, to elemental manipulation and unimaginable power. As a brave adventurer, you have been chosen to harness the power of these crystals and restore balance to the realm.\n" +
                "\n" +
                "As you traverse the enchanting landscapes of Crystallis, you will encounter breathtaking vistas, lush forests, and spectacular ruins, each holding secrets waiting to be unlocked. Along the way, you will meet fascinating characters, each with their own unique perspectives and stories, who will aid you on your quest with valuable knowledge and guidance.\n" +
                "\n" +
                "But be prepared, for the journey ahead will challenge your every skill and test your determination. The world of Crystallis is fraught with perilous obstacles and cunning adversaries. Harness the power of the crystals to unleash devastating spells and summon mighty creatures to aid you in battle. Acquire new crystals, upgrade their powers, and uncover their hidden potential to become a force to be reckoned with.\n" +
                "\n" +
                "Yet Crystallis is not just about combat. It offers a deep and rewarding crafting system, allowing you to infuse your crystals with unique properties to create powerful artifacts and equipment. Unearth rare materials, explore hidden dungeons, and delve into forgotten tombs to unlock the secrets of ancient civilizations.\n" +
                "\n" +
                "Beyond the allure of exploration and combat, Crystallis offers a rich and intricate storyline. Unravel the mysteries of the crystals' origin and discover the ancient prophecies that foretell the fate of the realm. Your choices matter, as they will shape the course of events and determine the future of Crystallis and its inhabitants.\n")
    }
}