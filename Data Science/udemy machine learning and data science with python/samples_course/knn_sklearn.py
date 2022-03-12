'''
	Implementação do kNN com sklearn
	dataset: https://archive.ics.uci.edu/ml/datasets/Haberman%27s+Survival
	Sobrevivência de pacientes submetidos a cirurgia de câncer de mama
'''

from sklearn.neighbors import KNeighborsClassifier

entradas, saidas = [], []

with open('dataset.data', 'r') as f:
	for linha in f.readlines():
		atrib = linha.replace('\n','').split(',')
		# desconsiderando o ano da operação
		entradas.append([int(atrib[0]), int(atrib[2])])
		saidas.append(int(atrib[3]))

p = 0.6
limite = int(p * len(entradas))
neigh = KNeighborsClassifier(n_neighbors=15)
neigh.fit(entradas[:limite], saidas[:limite])

labels = neigh.predict(entradas[limite:])
acertos, indice_label = 0, 0
for i in range(limite, len(entradas)):
	if labels[indice_label] == saidas[i]:
		acertos += 1
	indice_label += 1

print('Total de treinamento: %d' % limite)
print('Total de testes: %d' % (len(entradas) - limite))
print('Total de acertos: %d' % acertos)
print('Porcentagem de acertos: %.2f%%' % (100 * acertos / (len(entradas) - limite)))
