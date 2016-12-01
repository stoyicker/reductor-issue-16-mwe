package demo.pkg.name

import com.google.auto.value.AutoValue
import com.yheriatovych.reductor.annotations.CombinedState
import demo.pkg.name.person.Person

/**
 * Representation of a combined app state.
 */
@AutoValue
@CombinedState
abstract class AppState {

    /**
     * The list of people in the state.
     */
    abstract fun personList(): List<Person>

    /**
     * Factory class to instantiate app states.
     */
    companion object Factory {

        /**
         * Creates an app state.
         *
         * @param personList The source person list.
         */
        fun createFrom(personList: List<Person>): AppState {
            return AutoValue_AppState(personList)
        }
    }
}
