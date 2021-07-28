# Usage

This project contains 4 annotations, they are all used on classes together with utils in package `src/main/java/utils`. The introduction is as follows if we have a class `ParamsValidation`.

```java
class ParamsValidation{
  private Object param1;
  private Object param2;
  private Object param3;
  private Object param4;
}
```

## Or

```java
@Or(values = {"param1", "param2"})
class ParamsValidation{
  private Object param1;
  private Object param2;
  private Object param3;
  private Object param4;
}
```

If you pass an object of `ParamsValidation` in `ValidationUtils.validateOr()`, this means the properties of the object named `param1` and `param2` must exist at least one, otherwise `ValidationUtils.validate()` will throw an exception.

## And

```java
@And(values = {"param1", "param2", "param3"})
class ParamsValidation{
  private Object param1;
  private Object param2;
  private Object param3;
  private Object param4;
}
```

If you pass an object of `ParamsValidation` in `ValidationUtils.validateAnd()`, different with `Or` , this means the properties of the object named `param1`, `param2`  and `param3` must all exist.

## IntricateOr

```java
@IntricateOr(andRelations = {@And(values = {"param1, param4"})}, orRelations = {@Or(values = {"param2", "param3"})
class ParamsValidation{
  private Object param1;
  private Object param2;
  private Object param3;
  private Object param4;
}
```

You can add several `And` and `Or` in `IntricateOr`  and use `ValidationUtils.validateIntricateOr()` , which means the `And` and `Or` validations in `IntricateOr` must be passed at least one.

## IntricateAnd

```java
@IntricateAnd(andRelations = {@And(values = {"param4"})}, orRelations = {@Or(values = "param3")})
class ParamsValidation{
  private Object param1;
  private Object param2;
  private Object param3;
  private Object param4;
}
```

You can add several `And` and `Or` in `IntricateAnd` too and use `ValidationUtils.validateIntricateAnd()` , which means every `And` and `Or` validation in `IntricateAnd` must be passed.

