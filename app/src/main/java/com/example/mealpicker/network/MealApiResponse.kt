import com.example.mealpicker.model.Meal
import com.example.mealpicker.network.APIMeal
import com.example.mealpicker.network.asDomainObject
import kotlinx.serialization.Serializable

@Serializable
data class MealApiResponse(val meals: List<APIMeal>)
