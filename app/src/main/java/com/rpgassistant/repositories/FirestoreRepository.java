package com.rpgassistant.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.rpgassistant.models.Hero;

import java.util.ArrayList;
import java.util.List;

import static com.rpgassistant.repositories.AuthRepository.USERS;

public class FirestoreRepository {

    public static String HEROES = "Heroes";
    private static String TAG = "FirestoreRepository";
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    private FirebaseUser firebaseUser;
    private FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
    private CollectionReference usersRef = rootRef.collection(USERS);
    private CollectionReference heroesRef;

    public FirestoreRepository() {
        firebaseUser = firebaseAuth.getCurrentUser();
        heroesRef = usersRef.document(firebaseUser.getUid()).collection(HEROES);
    }

    public MutableLiveData<List<Hero>> getAllHeroes() {
        MutableLiveData<List<Hero>> heroMutableLiveData = new MutableLiveData<>();
        ArrayList<Hero> heroes = new ArrayList<>();
        heroesRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                for (QueryDocumentSnapshot document : task.getResult()) {
                        Hero hero = document.toObject(Hero.class);
                        hero.setId(document.getId());
                        heroes.add(hero);
                    heroMutableLiveData.setValue(heroes);
                }
            }
        });
        return heroMutableLiveData;
    }
    public void addHero(Hero hero){
        heroesRef.add(hero).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                Log.d(TAG, "Added Hero");
            }
        });
    }
    public void updateHero(Hero hero){
        heroesRef.document(hero.getId()).set(hero);
    }
    public void deleteHero(Hero hero){
        heroesRef.document(hero.getId()).delete();
    }
}
