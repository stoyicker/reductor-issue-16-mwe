package demo.pkg.name

import com.yheriatovych.reductor.Action
import com.yheriatovych.reductor.Reducer
import demo.pkg.name.person.Person

/**
 * Reducer for AppState.
 */
class AppStateReducer(val peopleListReducer: Reducer<List<Person>>): Reducer<AppState> {

    override fun reduce(state: AppState, action: Action): AppState {
        val initialPersonList = state.personList()
        val reducedPersonList = peopleListReducer.reduce(initialPersonList, action)

        return if (initialPersonList == reducedPersonList) {
            state
        } else {
            AppState.createFrom(reducedPersonList)
        }
    }

}
