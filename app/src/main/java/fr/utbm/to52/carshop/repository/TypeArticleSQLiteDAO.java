package fr.utbm.to52.carshop.repository;

import android.content.ContentValues;
import android.content.Context;

import java.util.Map;

import fr.utbm.to52.carshop.entity.TypeArticle;
import fr.utbm.to52.carshop.utils.DataBaseUtils.Column;
import fr.utbm.to52.carshop.utils.DataBaseUtils.DatabaseInfoProvider;
import fr.utbm.to52.carshop.utils.DataBaseUtils.Table;

/**
 * @author Youssoupha Sambe <youssoupha.sambe@utbm.fr>.
 */
public class TypeArticleSQLiteDAO extends BaseSQLiteDao implements BaseDAO<TypeArticle> {

    /**
     * The table typeArticle used for operations
     */
    private final Table typeArticleTable;

    public TypeArticleSQLiteDAO(Context context, Table typeArticleTable) {
        super(context);

        this.typeArticleTable = DatabaseInfoProvider.getMapOfDatabaseTables().get("ARTICLE");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeArticle ins(TypeArticle obj) {
        TypeArticle typeArticle = obj;
        ContentValues values = new ContentValues();
        Map<String, Column> columns = typeArticleTable.getColumns();

        values.put(columns.get("nomType").toString(), typeArticle.getNomType());

        typeArticle.setIdType(sqLiteDatabase.insert(typeArticleTable.getTableName(), null, values));

        return typeArticle;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void upd(TypeArticle obj) {
        TypeArticle typeArticle = obj;
        ContentValues values = new ContentValues();
        Map<String, Column> columns = typeArticleTable.getColumns();

        values.put(columns.get("idType").toString(), typeArticle.getIdType());
        values.put(columns.get("nomType").toString(), typeArticle.getNomType());

        sqLiteDatabase.update(
                typeArticleTable.getTableName(),
                values,
                typeArticleTable.getPrimaryKey().toString() + " = ?",
                new String[]{String.valueOf(typeArticle.getIdType())});
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void del(long id) {
        sqLiteDatabase.delete(
                typeArticleTable.getTableName(),
                typeArticleTable.getPrimaryKey().toString() + " = ?",
                new String[]{String.valueOf(id)});
    }

    @Override
    public TypeArticle get(long id) {
        return null;
    }
}
