package es.udc.vvs.dfa.generador;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.PrimitiveGenerators;
import net.java.quickcheck.generator.iterable.Iterables;
import static net.java.quickcheck.generator.CombinedGenerators.lists;
import static net.java.quickcheck.generator.PrimitiveGenerators.integers;
import static net.java.quickcheck.generator.PrimitiveGenerators.strings;

import org.junit.Test;

import es.udc.vvs.dfa.dfa.Alphabet;
import es.udc.vvs.dfa.dfa.DFA;
import es.udc.vvs.dfa.dfa.State;
import es.udc.vvs.dfa.dfa.Symbol;
import es.udc.vvs.dfa.dfa.Transition;
import es.udc.vvs.dfa.util.GenList;

// test con quickcheck.generator
public class GeneradorTest {
        //Genera Symbols
	class GeneradorSymbol implements Generator<Symbol>{
		public Symbol next(){
			Symbol s = new Symbol(strings().next());

			return s;
		}
	}
        
        //Genera States
	class GeneradorState implements Generator<State>{
		public State next(){
			State s = new State(strings().next());

			return s;
		}
	}
        
        //Genera Alphabets
	class GeneradorAlphabet implements Generator<Alphabet>{
		public Alphabet next(){
			Alphabet a = new Alphabet(100);

			return a;
		}
	}
        
        //Genera Transitions
	class GeneradorTransition implements Generator<Transition>{
		public Transition next(){
                    GeneradorSymbol s = new GeneradorSymbol();
                    Symbol symbol = s.next();
                    GeneradorState st = new GeneradorState();
                    State state = st.next();
                    Transition a = new Transition(state,state,symbol);

                    return a;
		}
	}
        
        //Genera GenLists
	class GeneradorGenList implements Generator<GenList>{
		public GenList next(){
                    
                    GenList a = new GenList();

                    return a;
		}
	}
        
        //Genera <State>GenLists
	class GeneradorGenListStates implements Generator<GenList>{
		public GenList next(){
                    GeneradorState st = new GeneradorState();
                    State state = st.next();
                    GenList a = new GenList();
                    a.add(state);
                    a.add(state);
                    return a;
		}
	}
        
        //Genera <Transition>GenLists
	class GeneradorGenListTransitions implements Generator<GenList>{
		public GenList next(){
                    GeneradorTransition st = new GeneradorTransition();
                    Transition transition = st.next();
                    GenList a = new GenList();
                    a.add(transition);
                    a.add(transition);
                    return a;
		}
	}
        
        //Genera DFAs
	class GeneradorDFA implements Generator<DFA>{
		public DFA next(){
                    GeneradorAlphabet ga = new GeneradorAlphabet();
                    Alphabet a = ga.next();
                    GeneradorState st = new GeneradorState();
                    State state = st.next();
                    GeneradorGenListStates gs = new GeneradorGenListStates();
                    GenList<State> initialStates = gs.next();
                    GenList<State> finalStates = gs.next();
                    GeneradorGenListTransitions gt = new GeneradorGenListTransitions();
                    GenList<Transition> transitions = gt.next();
                    
                    DFA dfa = new DFA(initialStates,a,state,finalStates,transitions);
                    
                    return dfa;
		}
	}
        
        @Test
	public void addNewSymbolAlphabetTest(){
		for (Alphabet a : Iterables.toIterable(new GeneradorAlphabet())){
			Integer numero = integers(1,50).next();
                        for(int i=0;i<numero;i++){
                            GeneradorSymbol s = new GeneradorSymbol();
                            Symbol symbol = s.next();
                            a.addNewSymbol(symbol);
			}
		}
	}
        
        @Test
	public void addGenListTest(){
		for (GenList a : Iterables.toIterable(new GeneradorGenList())){
			Integer numero = integers(1,100).next();
                        for(int i=0;i<numero;i++){
                            GeneradorSymbol s = new GeneradorSymbol();
                            Symbol symbol = s.next();
                            a.add(symbol);
			}
		}
	}
}
