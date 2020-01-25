package com.jaafoura.foodfacts.data.mappers;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class is used to map an object (or Collection) of a class to an object (or Collection) of another class. This
 * abstraction handles Collections and null parameters, allowing the children classes to focus exclusively on the object
 * mapping.
 */
public abstract class BaseDataMapper<T, R> {

  /**
   * Transform a Collection of {@link T} into a List of {@link R}.
   *
   * @param objectEntityCollection Object Collection to be transformed.
   * @return {@link R} if valid {@link T} otherwise null.
   */
  public List<R> transform(Collection<T> objectEntityCollection) {
    List<R> objectList = new ArrayList<>();
    if (objectEntityCollection != null) {
      R object;
      for (T objectEntity : objectEntityCollection) {
        object = transform(objectEntity);
        if (object != null) {
          objectList.add(object);
        }
      }
    }
    return objectList;
  }

  /**
   * Transform a {@link T} into a {@link R}.
   *
   * @param objectEntity Object to be transformed.
   * @return {@link R} if valid {@link T} otherwise null.
   */
  public R transform(T objectEntity) {
    R object = null;
    if (objectEntity != null) {
      object = createObject(objectEntity);
    }
    return object;
  }

  /**
   * Create a {@link R} object from a non null {@link T} object.
   *
   * @param sourceObject source object used for creation the new one
   * @return R object
   */
  @NonNull
  public abstract R createObject(@NonNull T sourceObject);

}
