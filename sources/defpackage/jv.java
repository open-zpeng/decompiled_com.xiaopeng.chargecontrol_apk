package defpackage;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;
/* compiled from: $Gson$Types.java */
/* renamed from: jv  reason: default package */
/* loaded from: classes.dex */
public final class jv {
    public static final Type[] a = new Type[0];

    /* compiled from: $Gson$Types.java */
    /* renamed from: jv$a */
    /* loaded from: classes.dex */
    public static final class a implements GenericArrayType, Serializable {
        public final Type c;

        public a(Type type) {
            this.c = jv.a(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && jv.a(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.c;
        }

        public int hashCode() {
            return this.c.hashCode();
        }

        public String toString() {
            return jv.e(this.c) + "[]";
        }
    }

    /* compiled from: $Gson$Types.java */
    /* renamed from: jv$b */
    /* loaded from: classes.dex */
    public static final class b implements ParameterizedType, Serializable {
        public final Type c;
        public final Type d;
        public final Type[] e;

        public b(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z = true;
                boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z2) {
                    z = false;
                }
                iv.a(z);
            }
            this.c = type == null ? null : jv.a(type);
            this.d = jv.a(type2);
            this.e = (Type[]) typeArr.clone();
            int length = this.e.length;
            for (int i = 0; i < length; i++) {
                iv.a(this.e[i]);
                jv.b(this.e[i]);
                Type[] typeArr2 = this.e;
                typeArr2[i] = jv.a(typeArr2[i]);
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && jv.a(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.e.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.c;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.d;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.e) ^ this.d.hashCode()) ^ jv.a((Object) this.c);
        }

        public String toString() {
            int length = this.e.length;
            if (length == 0) {
                return jv.e(this.d);
            }
            StringBuilder sb = new StringBuilder((length + 1) * 30);
            sb.append(jv.e(this.d));
            sb.append("<");
            sb.append(jv.e(this.e[0]));
            for (int i = 1; i < length; i++) {
                sb.append(", ");
                sb.append(jv.e(this.e[i]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* compiled from: $Gson$Types.java */
    /* renamed from: jv$c */
    /* loaded from: classes.dex */
    public static final class c implements WildcardType, Serializable {
        public final Type c;
        public final Type d;

        public c(Type[] typeArr, Type[] typeArr2) {
            iv.a(typeArr2.length <= 1);
            iv.a(typeArr.length == 1);
            if (typeArr2.length == 1) {
                iv.a(typeArr2[0]);
                jv.b(typeArr2[0]);
                iv.a(typeArr[0] == Object.class);
                this.d = jv.a(typeArr2[0]);
                this.c = Object.class;
                return;
            }
            iv.a(typeArr[0]);
            jv.b(typeArr[0]);
            this.d = null;
            this.c = jv.a(typeArr[0]);
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && jv.a(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Type type = this.d;
            return type != null ? new Type[]{type} : jv.a;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return new Type[]{this.c};
        }

        public int hashCode() {
            Type type = this.d;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.c.hashCode() + 31);
        }

        public String toString() {
            if (this.d != null) {
                StringBuilder a = jg.a("? super ");
                a.append(jv.e(this.d));
                return a.toString();
            } else if (this.c == Object.class) {
                return "?";
            } else {
                StringBuilder a2 = jg.a("? extends ");
                a2.append(jv.e(this.c));
                return a2.toString();
            }
        }
    }

    public static Type a(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new a(a((Type) cls.getComponentType())) : cls;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            return new a(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
            }
            return type;
        }
    }

    public static Type b(Type type, Class<?> cls, Class<?> cls2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        iv.a(cls2.isAssignableFrom(cls));
        return a(type, cls, a(type, cls, cls2));
    }

    public static Type c(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return ((Class) type).getComponentType();
    }

    public static Class<?> d(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            iv.a(rawType instanceof Class);
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Array.newInstance(d(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            if (type instanceof WildcardType) {
                return d(((WildcardType) type).getUpperBounds()[0]);
            }
            String name = type == null ? "null" : type.getClass().getName();
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + name);
        }
    }

    public static String e(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static void b(Type type) {
        iv.a(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }

    public static boolean a(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Type ownerType = parameterizedType.getOwnerType();
                Type ownerType2 = parameterizedType2.getOwnerType();
                return (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        } else if (type instanceof WildcardType) {
            if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                WildcardType wildcardType2 = (WildcardType) type2;
                return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
            }
            return false;
        } else if ((type instanceof TypeVariable) && (type2 instanceof TypeVariable)) {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
        } else {
            return false;
        }
    }

    public static int a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static Type a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return a(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Type a(Type type, Class<?> cls) {
        Type b2 = b(type, cls, Collection.class);
        if (b2 instanceof WildcardType) {
            b2 = ((WildcardType) b2).getUpperBounds()[0];
        }
        if (b2 instanceof ParameterizedType) {
            return ((ParameterizedType) b2).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    public static Type a(Type type, Class<?> cls, Type type2) {
        return a(type, cls, type2, new HashSet());
    }

    public static Type a(Type type, Class<?> cls, Type type2, Collection<TypeVariable> collection) {
        TypeVariable typeVariable;
        do {
            int i = 0;
            if (type2 instanceof TypeVariable) {
                typeVariable = (TypeVariable) type2;
                if (collection.contains(typeVariable)) {
                    return type2;
                }
                collection.add(typeVariable);
                GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
                Class cls2 = genericDeclaration instanceof Class ? (Class) genericDeclaration : null;
                if (cls2 != null) {
                    Type a2 = a(type, cls, (Class<?>) cls2);
                    if (a2 instanceof ParameterizedType) {
                        TypeVariable[] typeParameters = cls2.getTypeParameters();
                        int length = typeParameters.length;
                        while (i < length) {
                            if (typeVariable.equals(typeParameters[i])) {
                                type2 = ((ParameterizedType) a2).getActualTypeArguments()[i];
                                continue;
                            } else {
                                i++;
                            }
                        }
                        throw new NoSuchElementException();
                    }
                }
                type2 = typeVariable;
                continue;
            } else {
                if (type2 instanceof Class) {
                    Class cls3 = (Class) type2;
                    if (cls3.isArray()) {
                        Class<?> componentType = cls3.getComponentType();
                        Type a3 = a(type, cls, componentType, collection);
                        return componentType == a3 ? cls3 : new a(a3);
                    }
                }
                if (type2 instanceof GenericArrayType) {
                    GenericArrayType genericArrayType = (GenericArrayType) type2;
                    Type genericComponentType = genericArrayType.getGenericComponentType();
                    Type a4 = a(type, cls, genericComponentType, collection);
                    return genericComponentType == a4 ? genericArrayType : new a(a4);
                } else if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type2;
                    Type ownerType = parameterizedType.getOwnerType();
                    Type a5 = a(type, cls, ownerType, collection);
                    boolean z = a5 != ownerType;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    int length2 = actualTypeArguments.length;
                    while (i < length2) {
                        Type a6 = a(type, cls, actualTypeArguments[i], collection);
                        if (a6 != actualTypeArguments[i]) {
                            if (!z) {
                                actualTypeArguments = (Type[]) actualTypeArguments.clone();
                                z = true;
                            }
                            actualTypeArguments[i] = a6;
                        }
                        i++;
                    }
                    return z ? new b(a5, parameterizedType.getRawType(), actualTypeArguments) : parameterizedType;
                } else {
                    boolean z2 = type2 instanceof WildcardType;
                    WildcardType wildcardType = type2;
                    if (z2) {
                        WildcardType wildcardType2 = (WildcardType) type2;
                        Type[] lowerBounds = wildcardType2.getLowerBounds();
                        Type[] upperBounds = wildcardType2.getUpperBounds();
                        if (lowerBounds.length == 1) {
                            Type a7 = a(type, cls, lowerBounds[0], collection);
                            wildcardType = wildcardType2;
                            if (a7 != lowerBounds[0]) {
                                return new c(new Type[]{Object.class}, a7 instanceof WildcardType ? ((WildcardType) a7).getLowerBounds() : new Type[]{a7});
                            }
                        } else {
                            wildcardType = wildcardType2;
                            if (upperBounds.length == 1) {
                                Type a8 = a(type, cls, upperBounds[0], collection);
                                wildcardType = wildcardType2;
                                if (a8 != upperBounds[0]) {
                                    return new c(a8 instanceof WildcardType ? ((WildcardType) a8).getUpperBounds() : new Type[]{a8}, a);
                                }
                            }
                        }
                    }
                    return wildcardType;
                }
            }
        } while (type2 != typeVariable);
        return type2;
    }
}
