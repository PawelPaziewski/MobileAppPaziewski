package pl.paziewski.mobileapp

import androidx.room.*

@Entity
data class Result(
    @ColumnInfo(name = "nickname")
    var nickname: String,
    @ColumnInfo(name = "score")
    var score: Int,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

@Dao
interface ResultDao {

    @Query("select * from result order by score desc")
    fun getAllOrderedByScore(): List<Result>

    @Insert
    fun save(result: Result)
}

@Database(entities = [Result::class], version = 1)
abstract class AppDb : RoomDatabase() {
    abstract fun resultDao(): ResultDao
}